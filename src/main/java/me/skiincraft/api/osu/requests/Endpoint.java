package me.skiincraft.api.osu.requests;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSearch;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.User;
import me.skiincraft.api.osu.object.beatmap.UserBeatmapType;
import me.skiincraft.api.osu.object.beatmap.SearchFilter;
import me.skiincraft.api.osu.object.game.GameMode;
import me.skiincraft.api.osu.object.score.ScoreType;

import javax.annotation.Nullable;
import java.util.List;

public interface Endpoint {

    APIRequest<User> getOwn(GameMode mode);

    APIRequest<User> getUser(long userId, GameMode mode);

    APIRequest<List<Score>> getUserScore(long userId, ScoreType type);

    APIRequest<BeatmapScores> getBeatmapScores(long beatmapId);

    APIRequest<Score> getScore(GameMode mode, long scoreId);

    @Nullable
    APIRequest<List<User>> getUsers(long[] usersId);

    APIRequest<BeatmapSet> getBeatmapSet(long beatmapSetId);

    APIRequest<Beatmap> getBeatmap(long beatmapId);

    APIRequest<List<BeatmapSet>> getUserBeatmaps(long userId, UserBeatmapType type);

    APIRequest<BeatmapSearch> searchBeatmaps(String search, SearchFilter filter);

}
