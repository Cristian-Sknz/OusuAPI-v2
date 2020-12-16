package me.skiincraft.api.osu;

import com.google.gson.Gson;
import me.skiincraft.api.osu.exceptions.TokenException;
import me.skiincraft.api.osu.oauth.OAuthApplication;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.impl.EndpointImpl;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.impl.DefaultAPIRequest;
import me.skiincraft.api.osu.requests.impl.FakeAPIRequest;
import me.skiincraft.api.osu.requests.impl.TokenResponseParser;
import me.skiincraft.api.osu.util.ReflectionUtil;
import okhttp3.*;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class OsuAPI {

    private static final String URL_V2 = "https://osu.ppy.sh/api/v2/";
    private static OkHttpClient client = new OkHttpClient();
    private final OAuthApplication authApplication;
    private final List<Token> tokens = new ArrayList<>();

    public OsuAPI(OAuthApplication osuAuthApplication) {
        this.authApplication = osuAuthApplication;
        OsuAPI.client = (client == null) ? new OkHttpClient() : client;
    }

    public APIRequest<Token> createToken(@Nonnull String code) throws TokenException {
        if (code.length() < 600)
            throw new TokenException("Your code is not valid, as it has fewer characters than normal.");

        Request request = new Request.Builder()
                .url("https://osu.ppy.sh/oauth/token")
                .method("POST", makeAuthUrl(code))
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        DefaultAPIRequest<Token> token = new DefaultAPIRequest<>(request, this);
        Function<Response, Token> function = response -> {
            try {
                Token item = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), Token.class);
                ReflectionUtil.setField(item, "api", this);
                ReflectionUtil.setField(item, "endpoint", new EndpointImpl(item));

                tokens.add(item);
                return item;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };
        token.setFunction(function);
        token.setResponseParser((r) -> new TokenResponseParser<>(r, null));
        return token;
    }

    public APIRequest<Boolean> checkToken(@Nonnull String bearerToken) throws TokenException {
        if (bearerToken.length() < 800)
            throw new TokenException("Your token is not valid as it has fewer characters than normal.");

        Request request = new Request.Builder()
                .url(URL_V2 + "me/osu")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearerToken).build();

        return new DefaultAPIRequest<>(request, (response) -> true, this);
    }

    public APIRequest<Token> resumeToken(@Nonnull String bearerToken) throws TokenException {
        if (bearerToken.length() < 800)
            throw new TokenException("Your token is not valid as it has fewer characters than normal.");

        if (!checkToken(bearerToken).get()) {
            return null;
        }
        Token exists = tokens.stream().filter(token -> token.getToken().equalsIgnoreCase(bearerToken)).findFirst().orElse(null);
        if (exists == null) {
            tokens.add(exists = new Token(this, bearerToken));
        }

        return new FakeAPIRequest<>(exists, 200);
    }

    public OAuthApplication getAuthApplication() {
        return authApplication;
    }

    public OkHttpClient getClient() {
        return client;
    }

    private RequestBody makeAuthUrl(String code) {
        return new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("grant_type", "authorization_code")
                .addFormDataPart("client_id", String.valueOf(getAuthApplication().getClientId()))
                .addFormDataPart("client_secret", getAuthApplication().getClientSecret())
                .addFormDataPart("redirect_uri", getAuthApplication().getRedirectUri())
                .addFormDataPart("code", code)
                .build();
    }
}
