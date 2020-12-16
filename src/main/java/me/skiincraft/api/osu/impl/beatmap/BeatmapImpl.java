package me.skiincraft.api.osu.impl.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.FailTimes;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public class BeatmapImpl extends BeatmapCompactImpl implements Beatmap {

    private final float accuracy;
    private final float ar;
    private final float bpm;
    @SerializedName("count_circles")
    private final int circles;
    @SerializedName("count_sliders")
    private final int sliders;
    @SerializedName("count_spinners")
    private final int spinners;
    private final float drain;
    @SerializedName("hit_length")
    private final int hitlength;

    @SerializedName("beatmapset_id")
    private final long beatmapSetId;
    private final long passcount;
    private final long playcount;

    private final boolean convert;
    @SerializedName("is_scoreable")
    private final boolean isScoreable;

    private final float cs;
    @SerializedName("deleted_at")
    private final String deletedat;
    @SerializedName("last_updated")
    private final String lastUpdated;
    @SerializedName("ranked")
    private final int status;
    private final FailTimes failtimes;
    private final BeatmapSetCompactImpl beatmapset;

    public BeatmapImpl(float difficultRating, long beatmapId, int gamemodeId, int totalLength, String version, float accuracy, int ar, int bpm, int circles, int sliders, int spinners, int drain, int hitlength, long beatmapSetId, long passcount, long playcount, boolean convert, boolean isScoreable, float cs, String deletedat, String lastUpdated, int status, FailTimes failtimes, BeatmapSetCompactImpl beatmapset) {
        super(difficultRating, beatmapId, gamemodeId, totalLength, version);
        this.accuracy = accuracy;
        this.ar = ar;
        this.bpm = bpm;
        this.circles = circles;
        this.sliders = sliders;
        this.spinners = spinners;
        this.drain = drain;
        this.hitlength = hitlength;
        this.beatmapSetId = beatmapSetId;
        this.passcount = passcount;
        this.playcount = playcount;
        this.convert = convert;
        this.isScoreable = isScoreable;
        this.cs = cs;
        this.deletedat = deletedat;
        this.lastUpdated = lastUpdated;
        this.status = status;
        this.failtimes = failtimes;
        this.beatmapset = beatmapset;
    }

    @Override
    public float getAccuracy() {
        return accuracy;
    }

    @Override
    public float getAR() {
        return ar;
    }

    @Override
    public float getBPM() {
        return bpm;
    }

    @Override
    public int getCircles() {
        return circles;
    }

    @Override
    public int getSliders() {
        return sliders;
    }

    @Override
    public int getSpinners() {
        return spinners;
    }

    @Override
    public float getDrain() {
        return drain;
    }

    @Override
    public int getHitLength() {
        return hitlength;
    }

    @Override
    public long getBeatmapSetId() {
        return beatmapSetId;
    }

    @Override
    public long getPassCount() {
        return passcount;
    }

    @Override
    public long getPlayCount() {
        return playcount;
    }

    @Override
    public boolean isConverted() {
        return convert;
    }

    @Override
    public boolean isScoreable() {
        return isScoreable;
    }

    @Override
    public float getCS() {
        return cs;
    }

    @Nullable
    @Override
    public OffsetDateTime wasDeletedAt() {
        return (deletedat == null) ? null : OffsetDateTime.parse(deletedat);
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return OffsetDateTime.parse(lastUpdated);
    }

    @Override
    public Approval getStatus() {
        return Approval.getById(status);
    }

    @Override
    public FailTimes getFailTimes() {
        return failtimes;
    }

    @Override
    public BeatmapSetCompact getBeatmapSet() {
        return beatmapset;
    }
}
