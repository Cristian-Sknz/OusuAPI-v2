package me.skiincraft.api.osu.requests.impl.endpoint;

import com.google.gson.Gson;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSearch;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.ranking.Ranking;
import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.SimpleUser;
import me.skiincraft.api.osu.entity.user.User;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapImpl;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapSearchImpl;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapSetImpl;
import me.skiincraft.api.osu.impl.v2.ranking.RankingImpl;
import me.skiincraft.api.osu.impl.v2.score.BeatmapScoresImpl;
import me.skiincraft.api.osu.impl.v2.score.ScoreImpl;
import me.skiincraft.api.osu.impl.v2.user.UserImpl;
import me.skiincraft.api.osu.object.beatmap.SearchFilter;
import me.skiincraft.api.osu.object.beatmap.UserBeatmapType;
import me.skiincraft.api.osu.object.game.GameMode;
import me.skiincraft.api.osu.object.ranking.RankingFilter;
import me.skiincraft.api.osu.object.score.ScoreType;
import me.skiincraft.api.osu.requests.APIRequest;
import me.skiincraft.api.osu.requests.Endpoint;
import me.skiincraft.api.osu.requests.Token;
import me.skiincraft.api.osu.requests.impl.DefaultAPIRequest;
import me.skiincraft.api.osu.util.ReflectionUtil;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EndpointV2 implements Endpoint {

    private static final String URL_V2 = "https://osu.ppy.sh/api/v2/";
    private final Token token;

    public EndpointV2(Token token) {
        this.token = token;
    }

    @Override
    public APIRequest<User> getOwn(GameMode mode) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("me/%s", mode.name().toLowerCase()),
                (response -> {
                    try {
                        UserImpl userImpl = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), UserImpl.class);
                        ReflectionUtil.setField(ReflectionUtil.getField(userImpl, "statistics"), "user", userImpl);
                        return userImpl;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<SimpleUser> getUser(long userId, GameMode mode) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("users/%s/%s", userId, mode.name().toLowerCase()),
                (response -> {
                    try {
                        UserImpl userImpl = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), UserImpl.class);
                        ReflectionUtil.setField(ReflectionUtil.getField(userImpl, "statistics"), "user", userImpl);
                        return userImpl;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<List<Score>> getUserScore(long userId, ScoreType type) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("users/%s/scores/%s", userId, type.getNameToLowerCase()),
                (response -> {
                    try {
                        return Arrays.asList(new Gson().fromJson(Objects.requireNonNull(response.body()).string(), ScoreImpl[].class));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<BeatmapScores> getBeatmapScores(long beatmapId) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("beatmaps/%s/scores", beatmapId),
                (response -> {
                    try {
                        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), BeatmapScoresImpl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<Score> getScore(GameMode mode, long scoreId) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("scores/%s/%s", mode.name().toLowerCase(), scoreId),
                (response -> {
                    try {
                        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), ScoreImpl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Nullable
    @Override
    public APIRequest<List<User>> getUsers(long[] usersId) {
        return null;
        /*
        String users = Arrays.stream(usersId).mapToObj(String::valueOf).collect(Collectors.joining(","));
        return new DefaultAPIRequest<List<User>>(URL_V2 + String.format("users?ids[]=%s", users),
                (response -> {
                    try {
                        String resposta = Objects.requireNonNull(response.body()).string();
                        System.out.println(resposta);
                        return Arrays.asList(new Gson().fromJson(resposta, UserImpl[].class));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
         */
    }

    @Override
    public APIRequest<BeatmapSet> getBeatmapSet(long beatmapSetId) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("beatmapsets/%s", beatmapSetId),
                (response -> {
                    try {
                        BeatmapSetImpl beatmapSet = new Gson().fromJson(Objects.requireNonNull(response.body()).string(), BeatmapSetImpl.class);
                        for (BeatmapImpl beatmapImpl : (BeatmapImpl[]) Objects.requireNonNull(ReflectionUtil.getField(beatmapSet, "beatmaps"))) {
                            ReflectionUtil.setField(beatmapImpl, "beatmapset", beatmapSet);
                        }
                        for (BeatmapImpl beatmapImpl : (BeatmapImpl[]) Objects.requireNonNull(ReflectionUtil.getField(beatmapSet, "converts"))) {
                            ReflectionUtil.setField(beatmapImpl, "beatmapset", beatmapSet);
                        }
                        return beatmapSet;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<Beatmap> getBeatmap(long beatmapId) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("beatmaps/%s", beatmapId),
                (response -> {
                    try {
                        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), BeatmapImpl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<List<BeatmapSet>> getUserBeatmaps(long userId, UserBeatmapType type) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("users/%s/beatmapsets/%s", userId, type.getTypeName()),
                (response -> {
                    try {
                        return Arrays.asList(new Gson().fromJson(Objects.requireNonNull(response.body()).string(), BeatmapSetImpl[].class));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<Ranking> getRanking(RankingFilter filter) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("rankings/%s", filter.toQueueParameter()),
                (response -> {
                    try {
                        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), RankingImpl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

    @Override
    public APIRequest<BeatmapSearch> searchBeatmaps(String search, SearchFilter filter) {
        return new DefaultAPIRequest<>(URL_V2 + String.format("beatmapsets/search/?q=%s&%s", search, filter.toQueueParameter()),
                (response -> {
                    try {
                        return new Gson().fromJson(Objects.requireNonNull(response.body()).string(), BeatmapSearchImpl.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }), token);
    }

}
