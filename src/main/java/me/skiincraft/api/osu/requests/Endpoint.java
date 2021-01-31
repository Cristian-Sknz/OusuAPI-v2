package me.skiincraft.api.osu.requests;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSearch;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.ranking.Ranking;
import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.SimpleUser;
import me.skiincraft.api.osu.entity.user.User;
import me.skiincraft.api.osu.object.beatmap.SearchOption;
import me.skiincraft.api.osu.object.beatmap.UserBeatmapType;
import me.skiincraft.api.osu.object.game.GameMode;
import me.skiincraft.api.osu.object.ranking.RankingOption;
import me.skiincraft.api.osu.object.score.ScoreOption;

import javax.annotation.Nullable;
import java.util.List;

public interface Endpoint {

    default APIRequest<User> getOwn(GameMode mode) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<SimpleUser> getUser(long userId, GameMode mode);

    APIRequest<SimpleUser> getUser(String username, GameMode mode);

    APIRequest<List<Score>> getUserScore(long userId, ScoreOption option);

    APIRequest<List<Score>> getUserScore(String username, ScoreOption option);

    APIRequest<BeatmapScores> getBeatmapScores(long beatmapId);

    default APIRequest<List<Score>> getUserScore(long userId, long beatmapId){
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<List<Score>> getUserScore(String username, long beatmapId) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<Score> getScore(GameMode mode, long scoreId) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    @Nullable
    default APIRequest<List<User>> getUsers(long[] usersId) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");

    }

    default APIRequest<Ranking> getRanking(RankingOption filter) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<BeatmapSet> getBeatmapSet(long beatmapSetId);

    APIRequest<Beatmap> getBeatmap(long beatmapId);

    default APIRequest<List<BeatmapSet>> getUserBeatmaps(long userId, UserBeatmapType type) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<List<BeatmapSet>> getUserBeatmaps(String username, UserBeatmapType type) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    default APIRequest<BeatmapSearch> searchBeatmaps(String search, SearchOption filter) {
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

    APIRequest<Long> getUserId(String username);

}
