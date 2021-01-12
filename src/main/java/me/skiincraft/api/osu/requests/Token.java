package me.skiincraft.api.osu.requests;

import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.requests.Endpoint;

import javax.annotation.Nullable;

public interface Token {

    Endpoint getEndpoint();
    OsuAPI getAPI();
    String getToken();

    @Nullable
    default String getRefreshToken() {
        return null;
    }
    long getExpiresIn();
    boolean isV1();

}
