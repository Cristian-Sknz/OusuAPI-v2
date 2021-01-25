package me.skiincraft.api.osu.entity.ranking;

import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.object.ranking.SpotLight;
import me.skiincraft.api.osu.object.user.UserStatistics;

import javax.annotation.Nullable;
import java.util.List;

public interface Ranking {

    @Nullable
    List<BeatmapSet> getBeatmapSets();

    @Nullable
    SpotLight getSpotLight();

    List<UserStatistics> getUsers();

    int cursor();

    long size();

    long total();


}
