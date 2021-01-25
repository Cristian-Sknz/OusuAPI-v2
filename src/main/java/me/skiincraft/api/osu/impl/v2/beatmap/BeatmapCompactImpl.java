package me.skiincraft.api.osu.impl.v2.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.BeatmapCompact;
import me.skiincraft.api.osu.object.game.GameMode;

public class BeatmapCompactImpl implements BeatmapCompact {

    @SerializedName(value = "difficulty_rating", alternate = "difficultyrating")
    private final float difficultRating;
    @SerializedName(value = "id", alternate = {"beatmap_id"})
    private final long beatmapId;
    @SerializedName(value = "mode_int", alternate = "mode")
    private final String gamemodeId;
    @SerializedName("total_length")
    private final int totalLength;
    private final String version;

    public BeatmapCompactImpl(float difficultRating, long beatmapId, int gamemodeId, int totalLength, String version) {
        this.difficultRating = difficultRating;
        this.beatmapId = beatmapId;
        this.gamemodeId = String.valueOf(gamemodeId);
        this.totalLength = totalLength;
        this.version = version;
    }

    @Override
    public float getDifficultyRating() {
        return difficultRating;
    }

    @Override
    public long getBeatmapId() {
        return beatmapId;
    }

    @Override
    public GameMode getGameMode() {
        return GameMode.byName(gamemodeId);
    }

    @Override
    public int getTotalLength() {
        return totalLength;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "BeatmapCompact{" +
                "beatmapId=" + beatmapId +
                ", gamemodeId=" + gamemodeId +
                ", version='" + version + '\'' +
                ", difficultRating=" + difficultRating +
                ", totalLength=" + totalLength +
                '}';
    }
}
