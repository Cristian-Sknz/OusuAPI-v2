package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.FailTimes;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public interface Beatmap extends BeatmapCompact {

    float getAccuracy(); //

    float getAR(); //

    float getBPM();

    int getCircles();

    int getSliders();

    int getSpinners();

    int getMaxCombo();

    float getDrain();

    int getHitLength();

    long getBeatmapSetId();

    long getPassCount();

    long getPlayCount();

    boolean isConverted(); //

    boolean isScoreable();

    float getCS(); //

    @Nullable
    OffsetDateTime wasDeletedAt(); //

    OffsetDateTime getLastUpdated();

    Approval getStatus();

    FailTimes getFailTimes(); //

    BeatmapSetCompact getBeatmapSet();

    default BeatmapCompact toCompact() {
        return this;
    }

}
