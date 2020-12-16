package me.skiincraft.api.osu.requests;

import okhttp3.Response;

import java.util.function.Function;

public abstract class ResponseParser<T> {

    private final Response response;
    private Function<Response, T> function;

    public ResponseParser(Response response, Function<Response, T> function) {
        this.response = response;
        this.function = function;
    }

    public abstract boolean onFailure(Response response);

    public abstract boolean onSuccessful(Response response);

    public T parse() {
        if (!onFailure(response) || !onSuccessful(response)) {
            return null;
        }
        T item = getFunction().apply(response);
        response.close();
        return item;
    }

    public Function<Response, T> getFunction() {
        return function;
    }

    public ResponseParser<T> setFunction(Function<Response, T> function) {
        this.function = function;
        return this;
    }
}
