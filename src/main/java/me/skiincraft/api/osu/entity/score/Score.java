package me.skiincraft.api.osu.entity.score;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.object.beatmap.Mods;
import me.skiincraft.api.osu.object.score.ScoreRank;
import me.skiincraft.api.osu.object.score.ScoreStatistics;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.Objects;

public interface Score extends Comparable<Score> {

    default Long getBeatmapSetId() {
        return Objects.requireNonNull(getBeatmapSet()).getBeatmapSetId();
    }

    default long getBeatmapId() {
        return Objects.requireNonNull(getBeatmap()).getBeatmapId();
    }

    @Nullable
    default String getUsername() {
        return getUser().getUsername();
    }

    long getScoreId(); //

    @Nullable
    Long getBestId(); //

    long getUserId(); //

    float getAccuracy();

    Mods[] getMods();

    long getScore();

    long getMaxCombo(); //

    boolean isPerfect();

    ScoreStatistics getStatistics();

    float getPP();

    String getRank();

    default ScoreRank getScoreRank(){
        return ScoreRank.getScore(getRank());
    }

    OffsetDateTime getCreatedDate(); //

    boolean hasReplay();

    @Nullable
    Beatmap getBeatmap();

    @Nullable
    BeatmapSetCompact getBeatmapSet();

    UserCompact getUser();

    default String getScoreUrl(){
        return String.format("https://osu.ppy.sh/scores/%s/%s", (getBeatmap() == null) ? "osu" : getBeatmap().getGameMode().name(), getScoreId()).toLowerCase();
    }

    @Nullable
    Object getWeight();

    @Override
    default int compareTo(Score o) {
        if (o.getBeatmapId() != getBeatmapId()) {
            throw new IllegalArgumentException("You cannot compare a Score of different Beatmaps!");
        }
        return Long.compare(getScore(), o.getScore());
    }
}
