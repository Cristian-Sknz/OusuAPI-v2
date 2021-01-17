package me.skiincraft.api.osu.impl.v1;

import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.impl.APIToken;
import me.skiincraft.api.osu.requests.impl.FakeAPIRequest;
import me.skiincraft.api.osu.util.StaticClient;
import okhttp3.OkHttpClient;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class OsuAPIV1 implements OsuAPI {

    private final List<Token> tokens = new ArrayList<>();

    public OsuAPIV1() {
    }

    @Override
    public APIRequest<Token> createToken(@Nonnull String token) {
        APIToken apiToken = new APIToken(this, token, true);
        tokens.add(apiToken);
        return new FakeAPIRequest<>(apiToken, 200);
    }

    @Override
    public List<Token> getTokens() {
        return new ArrayList<>(tokens);
    }

    @Nonnull
    @Override
    public OkHttpClient getClient() {
        return StaticClient.getInstance().getClient();
    }

}
