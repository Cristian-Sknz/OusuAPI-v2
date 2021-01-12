package me.skiincraft.api.osu.util;

import okhttp3.OkHttpClient;

public class StaticClient {

    private static final StaticClient instance = new StaticClient();
    private final OkHttpClient client;

    private StaticClient() {
        this.client = new OkHttpClient();
    }

    public OkHttpClient getClient() {
        return client;
    }

    public static StaticClient getInstance() {
        return instance;
    }
}
