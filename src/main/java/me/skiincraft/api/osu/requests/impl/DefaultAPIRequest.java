package me.skiincraft.api.osu.requests.impl;

import me.skiincraft.api.osu.OsuAPI;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.ResponseParser;
import me.skiincraft.api.osu.requests.Token;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.function.Function;

public class DefaultAPIRequest<T> implements APIRequest<T> {

    private final String url;
    private final Request request;
    private final OsuAPI api;
    private final Token token;
    private int code = -1;
    private T item = null;
    private Function<Response, T> function;
    private Function<Response, ResponseParser<T>> responseParser;

    public DefaultAPIRequest(@Nonnull String url, @Nonnull OsuAPI api) {
        this.url = url;
        this.api = api;
        this.token = null;
        this.request = null;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public DefaultAPIRequest(@Nonnull Request request, @Nonnull OsuAPI api) {
        this.url = null;
        this.api = api;
        this.token = null;
        this.request = request;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public DefaultAPIRequest(@Nonnull String url, @Nonnull Function<Response, T> function, @Nonnull OsuAPI api) {
        this.url = url;
        this.function = function;
        this.api = api;
        this.token = null;
        this.request = null;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public DefaultAPIRequest(@Nonnull String url, @Nonnull Function<Response, T> function, @Nonnull Token token) {
        this.url = url;
        this.function = function;
        this.api = null;
        this.token = token;
        this.request = null;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public DefaultAPIRequest(@Nonnull Request request, @Nonnull Function<Response, T> function, @Nonnull OsuAPI api) {
        this.url = null;
        this.function = function;
        this.api = api;
        this.token = null;
        this.request = request;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public DefaultAPIRequest(@Nonnull Request request, @Nonnull Function<Response, T> function, @Nonnull Token token) {
        this.url = null;
        this.function = function;
        this.api = null;
        this.token = token;
        this.request = request;
        this.responseParser = (r) -> new DefaultResponseParser<>(r, function);
    }

    public void setResponseParser(@Nonnull Function<Response, ResponseParser<T>> responseParser) {
        this.responseParser = responseParser;
    }

    public void setFunction(@Nonnull Function<Response, T> function) {
        this.function = function;
    }

    @Override
    public T get() {
        if (item != null) {
            return item;
        }
        try {
            OkHttpClient client = getClient();
            Call call = client.newCall(buildRequest());
            ResponseParser<T> parser = responseParser.apply(call.execute()).setFunction(function);

            return this.item = parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
            this.code = 400;
            return null;
        }
    }

    private Request buildRequest() {
        if (this.request != null) {
            return this.request;
        }

        Request.Builder request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json");

        if (token != null) {
            return request.addHeader("Authorization", "Bearer " + token.getToken()).build();
        }
        return request.build();
    }

    @Override
    public int code() {
        return code;
    }

    private OkHttpClient getClient() {
        return (token == null) ? api.getClient() : token.getApi().getClient();
    }
}
