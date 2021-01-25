package me.skiincraft.api.osu.impl.v1.score;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.impl.v2.score.ScoreImpl;
import me.skiincraft.api.osu.object.beatmap.Mods;
import me.skiincraft.api.osu.object.score.ScoreStatistics;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ScoreV1Impl extends ScoreImpl implements Score {

    private final String username;
    @SerializedName(value = "enabled_mods")
    private final long enabledMods;

    @SerializedName(value = "replay_available")
    private final int replayAvailable;
    private final String date;
    @SerializedName("count50")
    private final int s50;
    @SerializedName("count100")
    private final int s100;
    @SerializedName("count300")
    private final int s300;
    @SerializedName("countgeki")
    private final int geki;
    @SerializedName("countkatu")
    private final int katu;
    @SerializedName("countmiss")
    private final int miss;
    @SerializedName(value = "beatmap_id")
    private long beatmapId;
    private ScoreStatistics scoreStatistics;

    public ScoreV1Impl(long scoreId, long userId, long maxCombo, long score, boolean perfect, ScoreStatistics statistics, float pp, String rank, String username, long enabledMods, int replayAvailable, String date) {
        super(scoreId, 0, userId, maxCombo, 0, null, score, perfect, replayAvailable == 1, statistics, pp, rank, null, null, null, null, null);
        this.username = username;
        this.enabledMods = enabledMods;
        this.replayAvailable = replayAvailable;
        this.date = date;
        this.s50 = statistics.get50();
        this.s100 = statistics.get100();
        this.s300 = statistics.get300();
        this.geki = statistics.getGeki();
        this.katu = statistics.getKatu();
        this.miss = statistics.getMiss();
    }

    @Override
    public Long getBestId() {
        return null;
    }

    @Override
    public Mods[] getMods() {
        return Mods.get(enabledMods);
    }

    @Override
    public boolean hasReplay() {
        return replayAvailable == 1;
    }

    @Override
    public BeatmapSetCompact getBeatmapSet() {
        return null;
    }

    @Override
    public Beatmap getBeatmap() {
        return null;
    }

    @Override
    public Long getBeatmapSetId() {
        return null;
    }

    @Override
    public long getBeatmapId() {
        return beatmapId;
    }

    public ScoreV1Impl setBeatmapId(long beatmapId) {
        this.beatmapId = beatmapId;
        return this;
    }

    @Override
    public OffsetDateTime getCreatedDate() {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atOffset(ZoneOffset.UTC);
    }

    @Override
    public Object getWeight() {
        return null;
    }

    @Override
    public float getAccuracy() {
        return calcAccuracy();
    }

    private float calcAccuracy() {
        return (float) (s300 * 300 + s100 * 100 + s50 * 50) / (s300 + s100 + s50 + miss) * 300;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public ScoreStatistics getStatistics() {
        return (scoreStatistics == null) ? scoreStatistics = new ScoreStatistics(s50, s100, s300, geki, katu, miss) : scoreStatistics;
    }
}
