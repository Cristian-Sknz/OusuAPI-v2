package me.skiincraft.api.osu.entity.score;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.object.beatmap.Mods;
import me.skiincraft.api.osu.object.score.ScoreStatistics;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public interface Score {

    default long getBeatmapSetId() {
        return getBeatmapSet().getBeatmapSetId();
    }

    default long getBeatmapId() {
        return getBeatmap().getBeatmapId();
    }
    default String getUsername() {
        return getUser().getUsername();
    }

    long getScoreId(); //
    long getBestId(); //
    long getUserId(); //
    float getAccuracy();
    Mods[] getMods();
    long getScore();
    long getMaxCombo(); //
    boolean isPerfect();
    ScoreStatistics getStatistics();
    float getPP();
    String getRank();
    OffsetDateTime getCreatedDate(); //
    boolean hasReplay();
    Beatmap getBeatmap();
    BeatmapSetCompact getBeatmapSet();
    UserCompact getUser();

    @Nullable
    Object getWeight();

}
