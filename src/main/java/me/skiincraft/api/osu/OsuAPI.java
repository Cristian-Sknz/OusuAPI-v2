package me.skiincraft.api.osu;

import me.skiincraft.api.osu.impl.v1.OsuAPIV1;
import me.skiincraft.api.osu.impl.v2.OsuAPIV2;
import me.skiincraft.api.osu.object.OAuthApplication;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.Token;
import okhttp3.OkHttpClient;

import javax.annotation.Nonnull;
import java.util.List;

public interface OsuAPI {

    static OsuAPI newAPIV2(OAuthApplication oAuthApplication) {
        return new OsuAPIV2(oAuthApplication);
    }

    static OsuAPI newAPIV1() {
        return new OsuAPIV1();
    }

    APIRequest<Token> createToken(@Nonnull String token);

    default APIRequest<Boolean> checkToken(@Nonnull String token) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<Token> resumeToken(@Nonnull String token) {
        return createToken(token);
    }

    default APIRequest<Token> refreshToken(@Nonnull String refreshToken) {
        return createToken(refreshToken);
    }

    List<Token> getTokens();

    OkHttpClient getClient();
}
