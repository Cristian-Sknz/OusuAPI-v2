package me.skiincraft.api.osu.object;

import javax.annotation.Nonnull;

public class OAuthApplication {

    private final long clientId;
    private final String clientSecret;
    private final String redirectUri;

    public OAuthApplication(long clientId, @Nonnull String clientSecret, @Nonnull String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    @Override
    public String toString() {
        return "OAuthApplication{" +
                "clientId=" + clientId +
                ", clientSecret='" + clientSecret + '\'' +
                ", redirectUri='" + redirectUri + '\'' +
                '}';
    }
}
