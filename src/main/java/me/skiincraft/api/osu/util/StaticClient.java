package me.skiincraft.api.osu.util;

import okhttp3.OkHttpClient;

public class StaticClient {

    private static final StaticClient instance = new StaticClient();
    private OkHttpClient client;

    private StaticClient() {}

    public static StaticClient getInstance() {
        return instance;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public OkHttpClient getClient() {
        if (!hasClient()){
            this.client = new OkHttpClient();
        }
        return client;
    }

    public boolean hasClient(){
        return client != null;
    }

}
