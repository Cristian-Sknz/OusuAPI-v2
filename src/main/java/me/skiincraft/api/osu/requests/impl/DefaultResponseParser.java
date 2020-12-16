package me.skiincraft.api.osu.requests.impl;

import me.skiincraft.api.osu.exceptions.RequestException;
import me.skiincraft.api.osu.exceptions.ResourceNotFoundException;
import me.skiincraft.api.osu.requests.ResponseParser;
import okhttp3.Response;

import java.io.IOException;
import java.util.function.Function;

public class DefaultResponseParser<T> extends ResponseParser<T> {

    private final int code;

    public DefaultResponseParser(Response response, Function<Response, T> function) {
        super(response, function);
        this.code = response.code();
    }

    @Override
    public boolean onFailure(Response response) {
        try {
            if (code >= 400 && code <= 401) {
                throw new RequestException("Unauthorized access, check that your credentials are correct.\n" + response.body().string());
            }
            if (code == 404) {
                throw new ResourceNotFoundException("This resource was not found by the API.\n" + response.body().string());
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean onSuccessful(Response response) {
        return true;
    }
}
