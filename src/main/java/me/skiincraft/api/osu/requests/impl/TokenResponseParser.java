package me.skiincraft.api.osu.requests.impl;

import me.skiincraft.api.osu.exceptions.TokenException;
import me.skiincraft.api.osu.requests.ResponseParser;
import okhttp3.Response;

import java.io.IOException;
import java.util.function.Function;

public class TokenResponseParser<T> extends ResponseParser<T> {

    public TokenResponseParser(Response response, Function<Response, T> function) {
        super(response, function);
    }

    @Override
    public boolean onFailure(Response response) {
        if (response.code() >= 400) {
            try {
                System.out.println(response.code());
                throw new TokenException(String.format("Your credentials may be incorrect:%n%s", response.body().string()));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean onSuccessful(Response response) {
        return true;
    }
}
