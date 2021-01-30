package me.skiincraft.api.osu.requests.impl.endpoint;

import com.google.gson.Gson;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.SimpleUser;
import me.skiincraft.api.osu.exceptions.ResourceNotFoundException;
import me.skiincraft.api.osu.impl.v1.beatmap.BeatmapSetV1Impl;
import me.skiincraft.api.osu.impl.v1.beatmap.BeatmapV1Impl;
import me.skiincraft.api.osu.impl.v1.score.ScoreV1Impl;
import me.skiincraft.api.osu.impl.v1.user.UserV1Impl;
import me.skiincraft.api.osu.impl.v2.score.BeatmapScoresImpl;
import me.skiincraft.api.osu.object.game.GameMode;
import me.skiincraft.api.osu.object.score.ScoreType;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.Endpoint;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.impl.DefaultAPIRequest;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EndpointV1 implements Endpoint {

    private static final String URL_V1 = "https://osu.ppy.sh/api/";
    private final Token token;

    public EndpointV1(Token token) {
        if (!token.isV1()) {
            throw new UnsupportedOperationException("You cannot use a v2 Token in the old API!");
        }
        this.token = token;
    }

    @Override
    public APIRequest<SimpleUser> getUser(long userId, GameMode mode) {
        return getUser(String.valueOf(userId), mode);
    }

    @Override
    public APIRequest<SimpleUser> getUser(String username, GameMode mode) {
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + String.format("get_user?u=%s&k=%s&m%s", username, token.getToken(), mode.getId())).build(),
                (response -> {
                    try {
                        return new Gson().fromJson(checkResponse(response), UserV1Impl[].class)[0];
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<List<Score>> getUserScore(long userId, ScoreType type) {
        return getUserScore(String.valueOf(userId), type);
    }

    @Override
    public APIRequest<List<Score>> getUserScore(String username, ScoreType type) {
        if (type.getAPIV1Endpoint() == null) {
            throw new UnsupportedOperationException("This method is not compatible with this version of the API");
        }
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + type.getAPIV1Endpoint() + String.format("?u=%s&k=%s", username, token.getToken())).build(),
                (response -> {
                    try {
                        return Arrays.asList(new Gson().fromJson(checkResponse(response), ScoreV1Impl[].class));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<List<Score>> getUserScore(long userId, long beatmapId) {
        return getUserScore(String.valueOf(userId), beatmapId);
    }

    @Override
    public APIRequest<List<Score>> getUserScore(String username, long beatmapId) {
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + "get_scores" + String.format("?u=%s&b=%s&k=%s", username, beatmapId, token.getToken())).build(),
                (response -> {
                    try {
                        return Arrays.stream(new Gson().fromJson(checkResponse(response), ScoreV1Impl[].class))
                                .map(sc -> sc.setBeatmapId(beatmapId))
                                .collect(Collectors.toList());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<BeatmapScores> getBeatmapScores(long beatmapId) {
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + "get_scores" + String.format("?b=%s&k=%s", beatmapId, token.getToken())).build(),
                (response -> {
                    try {
                        return new BeatmapScoresImpl(Arrays.stream(new Gson().fromJson(checkResponse(response), ScoreV1Impl[].class))
                                .map(sc -> sc.setBeatmapId(beatmapId))
                                .toArray(ScoreV1Impl[]::new), null, beatmapId);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<BeatmapSet> getBeatmapSet(long beatmapSetId) {
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + "get_beatmaps" + String.format("?s=%s&k=%s", beatmapSetId, token.getToken())).build(),
                (response -> {
                    try {
                        return new BeatmapSetV1Impl(new Gson().fromJson(checkResponse(response), BeatmapV1Impl[].class));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<Beatmap> getBeatmap(long beatmapId) {
        return new DefaultAPIRequest<>(new Request
                .Builder().url(URL_V1 + "get_beatmaps" + String.format("?b=%s&k=%s", beatmapId, token.getToken())).build(),
                (response -> {
                    try {
                        return new Gson().fromJson(checkResponse(response), BeatmapV1Impl[].class)[0];
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<Long> getUserId(String username) {
        String usersUrl = "https://osu.ppy.sh/users/";
        return new DefaultAPIRequest<>(new Request.Builder().url(usersUrl + username).build(),
                (response -> Long.parseLong(response.request().url().toString().replace(usersUrl, ""))), token);
    }

    private String checkResponse(Response response) throws IOException {
        String string = Objects.requireNonNull(response.body()).string();
        if (string.length() == 2)
            throw new ResourceNotFoundException("This resource was not found by the API.\n" + string);

        return string;
    }
}
