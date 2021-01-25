package me.skiincraft.api.osu.requests;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSearch;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.ranking.Ranking;
import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.SimpleUser;
import me.skiincraft.api.osu.entity.user.User;
import me.skiincraft.api.osu.object.beatmap.SearchFilter;
import me.skiincraft.api.osu.object.beatmap.UserBeatmapType;
import me.skiincraft.api.osu.object.game.GameMode;
import me.skiincraft.api.osu.object.ranking.RankingFilter;
import me.skiincraft.api.osu.object.score.ScoreType;

import javax.annotation.Nullable;
import java.util.List;

public interface Endpoint {

    default APIRequest<User> getOwn(GameMode mode) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<SimpleUser> getUser(long userId, GameMode mode);

    default APIRequest<SimpleUser> getUser(String username, GameMode mode) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<List<Score>> getUserScore(long userId, ScoreType type);

    default APIRequest<List<Score>> getUserScore(String username, ScoreType type) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<BeatmapScores> getBeatmapScores(long beatmapId);

    default APIRequest<Score> getScore(GameMode mode, long scoreId) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    @Nullable
    default APIRequest<List<User>> getUsers(long[] usersId) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");

    }

    default APIRequest<Ranking> getRanking(RankingFilter filter) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<BeatmapSet> getBeatmapSet(long beatmapSetId);

    APIRequest<Beatmap> getBeatmap(long beatmapId);

    default APIRequest<List<BeatmapSet>> getUserBeatmaps(long userId, UserBeatmapType type) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<BeatmapSearch> searchBeatmaps(String search, SearchFilter filter) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

}
