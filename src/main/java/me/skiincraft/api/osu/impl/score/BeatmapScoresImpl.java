package me.skiincraft.api.osu.impl.score;

import me.skiincraft.api.osu.entity.score.BeatmapScores;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.score.UserScore;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BeatmapScoresImpl implements BeatmapScores {

    private final ScoreImpl[] scores;
    private final UserScore userScore;

    public BeatmapScoresImpl(ScoreImpl[] scores, UserScore userScore) {
        this.scores = scores;
        this.userScore = userScore;
    }

    @Override
    public List<Score> getScores() {
        return Arrays.asList(scores);
    }

    @Nullable
    @Override
    public UserScore getUserScore() {
        return userScore;
    }

    @Override
    public String toString() {
        return "BeatmapScores{" +
                "beatmapId=" + Objects.requireNonNull(getBeatmap()).getBeatmapId() +
                ", size=" + (scores.length + ((hasUserScore()) ? 1 : 0)) +
                ", scores=" + Arrays.toString(scores) +
                ", userScore=" + userScore +
                '}';
    }
}
