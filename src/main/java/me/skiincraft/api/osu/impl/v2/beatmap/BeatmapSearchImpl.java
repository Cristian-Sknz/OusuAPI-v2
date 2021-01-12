package me.skiincraft.api.osu.impl.v2.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSearch;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;

import java.util.Arrays;
import java.util.List;

public class BeatmapSearchImpl implements BeatmapSearch {

    private final BeatmapSetImpl[] beatmapsets;
    private final String error;
    private final int total;
    @SerializedName("recommended_difficulty")
    private final float recommendedDifficulty;

    public BeatmapSearchImpl(BeatmapSetImpl[] beatmapsets, String error, int total, float recommendedDifficulty) {
        this.beatmapsets = beatmapsets;
        this.error = error;
        this.total = total;
        this.recommendedDifficulty = recommendedDifficulty;
    }


    @Override
    public List<BeatmapSet> getBeatmapSets() {
        return Arrays.asList(beatmapsets);
    }

    @Override
    public String error() {
        return error;
    }

    @Override
    public float getRecommendedDifficult() {
        return recommendedDifficulty;
    }

    @Override
    public int total() {
        return total;
    }

    @Override
    public String toString() {
        return "BeatmapSearch{" +
                "beatmapsets=" + Arrays.toString(beatmapsets) +
                ", error='" + error + '\'' +
                ", total=" + total +
                ", recommendedDifficulty=" + recommendedDifficulty +
                '}';
    }
}
