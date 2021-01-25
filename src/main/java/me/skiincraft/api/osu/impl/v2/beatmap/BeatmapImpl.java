package me.skiincraft.api.osu.impl.v2.beatmap;

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
    @SerializedName(value = "count_circles", alternate = {"count_normal"})
    private final int circles;
    @SerializedName(value = "count_sliders", alternate = {"count_slider"})
    private final int sliders;
    @SerializedName(value = "count_spinners", alternate = {"count_spinner"})
    private final int spinners;
    @SerializedName(value = "max_combo")
    private final int maxCombo;
    @SerializedName(value = "drain", alternate = {"diff_drain"})
    private final float drain;
    @SerializedName(value = "hit_length")
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
    @SerializedName(value = "last_updated", alternate = {"last_update"})
    private final String lastUpdated;
    @SerializedName(value = "ranked", alternate = {"approved"})
    private final int status;
    private final FailTimes failtimes;
    private final BeatmapSetCompactImpl beatmapset;


    //v1

    public BeatmapImpl(float difficultRating, long beatmapId, int gamemodeId, int totalLength, String version, float accuracy, int ar, int bpm, int circles, int sliders, int spinners, int maxCombo, int drain, int hitlength, long beatmapSetId, long passcount, long playcount, boolean convert, boolean isScoreable, float cs, String deletedat, String lastUpdated, int status, FailTimes failtimes, BeatmapSetCompactImpl beatmapset) {
        super(difficultRating, beatmapId, gamemodeId, totalLength, version);
        this.accuracy = accuracy;
        this.ar = ar;
        this.bpm = bpm;
        this.circles = circles;
        this.sliders = sliders;
        this.spinners = spinners;
        this.maxCombo = maxCombo;
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
    public int getMaxCombo() {
        return maxCombo;
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
        return OffsetDateTime.parse(getLastUpdatedString());
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

    protected String getLastUpdatedString() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "Beatmap{" +
                "beatmapId=" + getBeatmapId() +
                ", gamemodeId=" + getGameMode().getId() +
                ", version='" + getVersion() + '\'' +
                ", difficultRating=" + getDifficultyRating() +
                ", totalLenght=" + getTotalLength() +
                ", bpm=" + bpm +
                ", beatmapSetId=" + beatmapSetId +
                ", playcount=" + playcount +
                ", status=" + status +
                String.format(", beatmapset={%s}",
                        "title='" + getBeatmapSet().getTitle() + '\'' +
                                ", artist='" + getBeatmapSet().getArtist() + '\'' +
                                ", beatmapSetId=" + getBeatmapSet().getBeatmapSetId() + '\'' +
                                ", creator='" + getBeatmapSet().getCreator() + '\'' +
                                ", status=" + getBeatmapSet().getStatus() +
                                ", userId=" + getBeatmapSet().getUserId() +
                                "playcount=" + getBeatmapSet().getPlayCount()) +
                "}";
    }
}
