package me.skiincraft.api.osu.requests.impl;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.Endpoint;
import me.skiincraft.api.osu.requests.impl.endpoint.EndpointV1;
import me.skiincraft.api.osu.requests.impl.endpoint.EndpointV2;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicInteger;

public class APIToken implements Token {

    private static final AtomicInteger next = new AtomicInteger(0);
    private final OsuAPI api;
    @SerializedName("access_token")
    private final String token;
    @SerializedName("refresh_token")
    private final String refreshToken;
    @SerializedName("expires_in")
    private final long expiresIn;
    private final int id = next.getAndIncrement();
    private final boolean v1;

    private final Endpoint endpoint;

    public APIToken(@Nonnull OsuAPI api, @Nonnull String token, @Nonnull String refreshToken, long expiresIn) {
        this.api = api;
        this.token = token;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.endpoint = new EndpointV2(this);
        this.v1 = false;
    }

    public APIToken(@Nonnull OsuAPI api, @Nonnull String token, boolean v1) {
        this.api = api;
        this.token = token;
        this.refreshToken = null;
        this.expiresIn = -1;
        this.v1 = v1;
        this.endpoint = (v1) ? new EndpointV1(this) : new EndpointV2(this);
    }

    @Override
    public String getRefreshToken() {
        return refreshToken;
    }

    @Override
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @Override
    public OsuAPI getAPI() {
        return api;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public long getExpiresIn() {
        return expiresIn;
    }

    @Override
    public boolean isV1() {
        return v1;
    }
}
