package me.skiincraft.api.osu.impl.v2;

import com.google.gson.Gson;
import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.exceptions.TokenException;
import me.skiincraft.api.osu.object.OAuthApplication;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.impl.APIToken;
import me.skiincraft.api.osu.requests.impl.DefaultAPIRequest;
import me.skiincraft.api.osu.requests.impl.FakeAPIRequest;
import me.skiincraft.api.osu.requests.impl.TokenResponseParser;
import me.skiincraft.api.osu.requests.impl.endpoint.EndpointV2;
import me.skiincraft.api.osu.util.ReflectionUtil;
import me.skiincraft.api.osu.util.StaticClient;
import okhttp3.*;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class OsuAPIV2 implements OsuAPI {

    private static final String URL_V2 = "https://osu.ppy.sh/api/v2/";
    private final OAuthApplication authApplication;
    private final List<Token> tokens = new ArrayList<>();

    public OsuAPIV2(OAuthApplication osuAuthApplication) {
        this.authApplication = osuAuthApplication;
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
                Token item = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), APIToken.class);
                ReflectionUtil.setField(item, "api", this);
                ReflectionUtil.setField(item, "endpoint", new EndpointV2(item));

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
        if (bearerToken.length() < 700)
            throw new TokenException("Your token is not valid as it has fewer characters than normal.");

        Request request = new Request.Builder()
                .url(URL_V2 + "me/osu")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + bearerToken).build();

        return new DefaultAPIRequest<>(request, (response) -> true, this);
    }

    public APIRequest<Token> resumeToken(@Nonnull String bearerToken) throws TokenException {
        if (bearerToken.length() < 700)
            throw new TokenException("Your token is not valid as it has fewer characters than normal.");

        if (!checkToken(bearerToken).get()) {
            return null;
        }
        Token exists = tokens.stream().filter(token -> token.getToken().equalsIgnoreCase(bearerToken)).findFirst().orElse(null);
        if (exists == null) {
            tokens.add(exists = new APIToken(this, bearerToken, false));
        }

        return new FakeAPIRequest<>(exists, 200);
    }

    @Override
    public APIRequest<Token> refreshToken(@Nonnull String refreshToken) {
        if (refreshToken.length() < 600)
            throw new TokenException("Your code is not valid, as it has fewer characters than normal.");

        Request request = new Request.Builder()
                .url("https://osu.ppy.sh/oauth/token")
                .method("POST", makeRefreshAuthUrl(refreshToken))
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .build();

        DefaultAPIRequest<Token> token = new DefaultAPIRequest<>(request, this);
        Function<Response, Token> function = response -> {
            try {
                Token item = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), Token.class);
                ReflectionUtil.setField(item, "api", this);
                ReflectionUtil.setField(item, "endpoint", new EndpointV2(item));

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

    @Override
    public List<Token> getTokens() {
        return tokens;
    }

    public OAuthApplication getAuthApplication() {
        return authApplication;
    }

    public OkHttpClient getClient() {
        return StaticClient.getInstance().getClient();
    }

    private RequestBody makeAuthUrl(String code) {
        return new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("client_id", String.valueOf(getAuthApplication().getClientId()))
                .addFormDataPart("client_secret", getAuthApplication().getClientSecret())
                .addFormDataPart("code", code)
                .addFormDataPart("grant_type", "authorization_code")
                .addFormDataPart("redirect_uri", getAuthApplication().getRedirectUri())
                .build();
    }

    private RequestBody makeRefreshAuthUrl(String refreshToken) {
        return new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("grant_type", "refresh_token")
                .addFormDataPart("client_id", String.valueOf(getAuthApplication().getClientId()))
                .addFormDataPart("client_secret", getAuthApplication().getClientSecret())
                .addFormDataPart("redirect_uri", getAuthApplication().getRedirectUri())
                .addFormDataPart("refresh_token", refreshToken)
                .build();
    }
}
