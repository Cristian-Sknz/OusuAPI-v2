package me.skiincraft.api.osu.impl.v2.ranking;

import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.ranking.Ranking;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapSetImpl;
import me.skiincraft.api.osu.object.ranking.SpotLight;
import me.skiincraft.api.osu.object.user.UserStatistics;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public class RankingImpl implements Ranking {

    private final UserStatistics[] ranking;
    private final long total;
    private BeatmapSetImpl[] beatmapsets;
    private SpotLight spotlight;
    private Map<String, String> cursor;

    public RankingImpl(UserStatistics[] ranking, long total) {
        this.ranking = ranking;
        this.total = total;
    }

    @Nullable
    @Override
    public List<BeatmapSet> getBeatmapSets() {
        return (beatmapsets == null) ? new ArrayList<>() : Arrays.stream(beatmapsets).collect(Collectors.toList());
    }

    @Nullable
    @Override
    public SpotLight getSpotLight() {
        return spotlight;
    }

    @Override
    public List<UserStatistics> getUsers() {
        return Arrays.stream(ranking).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    @Override
    public int cursor() {
        return (cursor == null) ? 0 : Integer.parseInt(cursor.get("page"));
    }

    @Override
    public long size() {
        return ranking.length;
    }

    @Override
    public long total() {
        return total;
    }


}
