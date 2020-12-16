package me.skiincraft.api.osu.entity.score;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public interface BeatmapScores {

    List<Score> getScores();
    @Nullable
    UserScore getUserScore();
    @Nullable
    default Beatmap getBeatmap() {
        return (size() == 0) ? null : getScores().get(0).getBeatmap();
    }
    default boolean hasUserScore() {
        return Objects.nonNull(getUserScore());
    }
    default long size() {
        return getScores().size();
    }
}
