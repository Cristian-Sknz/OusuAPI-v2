package me.skiincraft.api.osu.impl.v2.score;

import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.score.UserScore;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class BeatmapScoresImpl implements BeatmapScores {

    private final ScoreImpl[] scores;
    private final UserScore userScore;
    private final long beatmapId;

    public BeatmapScoresImpl(ScoreImpl[] scores, UserScore userScore) {
        this.scores = scores;
        this.userScore = userScore;
        this.beatmapId = scores[0].getBeatmapId();
    }

    public BeatmapScoresImpl(ScoreImpl[] scores, UserScore userScore, long beatmapId) {
        this.scores = scores;
        this.userScore = userScore;
        this.beatmapId = beatmapId;
    }

    @Override
    public List<Score> getScores() {
        return Arrays.asList(scores);
    }

    public long getBeatmapId() {
        return beatmapId;
    }

    @Nullable
    @Override
    public UserScore getUserScore() {
        return userScore;
    }

    @Override
    public String toString() {
        return "BeatmapScores{" +
                "beatmapId=" + beatmapId +
                ", size=" + (scores.length + ((hasUserScore()) ? 1 : 0)) +
                ", scores=" + Arrays.toString(scores) +
                ", userScore=" + userScore +
                '}';
    }
}
