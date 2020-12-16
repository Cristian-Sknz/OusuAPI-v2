package me.skiincraft.api.osu.oauth;

import javax.annotation.Nonnull;

public class OAuthApplication {

    private final long clientId;
    private final String clientSecret;
    private final String redirectUri;

    public OAuthApplication(@Nonnull long clientId, @Nonnull String clientSecret, @Nonnull String redirectUri) {
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
}
