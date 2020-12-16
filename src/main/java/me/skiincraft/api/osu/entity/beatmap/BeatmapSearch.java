package me.skiincraft.api.osu.entity.beatmap;

import java.util.List;

public interface BeatmapSearch {

    List<BeatmapSet> getBeatmapSets();

    String error();

    default boolean hasError() {
        return error() != null;
    }

    float getRecommendedDifficult();

    int total();

    default int size() {
        return total();
    }
}
