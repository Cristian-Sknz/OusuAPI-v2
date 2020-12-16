package me.skiincraft.api.osu.requests;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.requests.impl.EndpointImpl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

public class Token {

    private static final AtomicInteger next = new AtomicInteger(0);
    private final OsuAPI api;
    @SerializedName("access_token")
    private final String token;
    @SerializedName("refresh_token")
    private final String refreshToken;
    @SerializedName("expires_in")
    private final long expiresIn;
    private final int id = next.getAndIncrement();

    private final Endpoint endpoint;

    public Token(@Nonnull OsuAPI api, @Nonnull String token, @Nonnull String refreshToken, long expiresIn) {
        this.api = api;
        this.token = token;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.endpoint = new EndpointImpl(this);
    }

    public Token(@Nonnull OsuAPI api, @Nonnull String token) {
        this.api = api;
        this.token = token;
        this.refreshToken = null;
        this.expiresIn = -1;
        this.endpoint = new EndpointImpl(this);
    }

    public OsuAPI getApi() {
        return api;
    }

    public String getToken() {
        return token;
    }

    @Nullable
    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    @Override
    public String toString() {
        return "Token-" + id + "{" +
                "token='" + token + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
