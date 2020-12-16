package me.skiincraft.api.osu.impl.score;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.entity.score.Score;
import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.impl.beatmap.BeatmapImpl;
import me.skiincraft.api.osu.impl.beatmap.BeatmapSetCompactImpl;
import me.skiincraft.api.osu.impl.user.UserCompactImpl;
import me.skiincraft.api.osu.object.beatmap.Mods;
import me.skiincraft.api.osu.object.score.ScoreStatistics;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public class ScoreImpl implements Score {

    @SerializedName("id")
    private final long scoreId;
    @SerializedName("best_id")
    private final long bestId;
    @SerializedName("user_id")
    private final long userId;
    @SerializedName("max_combo")
    private final long maxCombo;
    private final float accuracy;
    private final String[] mods;
    private final long score;
    private final boolean perfect;
    private final boolean replay;
    private final ScoreStatistics statistics;
    private final float pp;
    private final String rank;
    private final BeatmapImpl beatmap;
    private final BeatmapSetCompactImpl beatmapset;
    private final UserCompactImpl user;
    @SerializedName("created_at")
    private final String createdDate;
    private final Object weight;

    public ScoreImpl(long scoreId, long bestId, long userId, long maxCombo, float accuracy, String[] mods, long score, boolean perfect, boolean replay, ScoreStatistics statistics, float pp, String rank, BeatmapImpl beatmap, BeatmapSetCompactImpl beatmapset, UserCompactImpl user, String createdDate, Object weight) {
        this.scoreId = scoreId;
        this.bestId = bestId;
        this.userId = userId;
        this.maxCombo = maxCombo;
        this.accuracy = accuracy;
        this.mods = mods;
        this.score = score;
        this.perfect = perfect;
        this.replay = replay;
        this.statistics = statistics;
        this.pp = pp;
        this.rank = rank;
        this.beatmap = beatmap;
        this.beatmapset = beatmapset;
        this.user = user;
        this.createdDate = createdDate;
        this.weight = weight;
    }

    @Override
    public long getScoreId() {
        return scoreId;
    }

    @Override
    public long getBestId() {
        return bestId;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public float getAccuracy() {
        return accuracy;
    }

    @Override
    public Mods[] getMods() {
        return Mods.get(mods);
    }

    @Override
    public long getScore() {
        return score;
    }

    @Override
    public long getMaxCombo() {
        return maxCombo;
    }

    @Override
    public boolean isPerfect() {
        return perfect;
    }

    @Override
    public ScoreStatistics getStatistics() {
        return statistics;
    }

    @Override
    public float getPP() {
        return pp;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public OffsetDateTime getCreatedDate() {
        return OffsetDateTime.parse(createdDate);
    }

    @Override
    public boolean hasReplay() {
        return replay;
    }

    @Override
    public Beatmap getBeatmap() {
        return beatmap;
    }

    @Override
    public BeatmapSetCompact getBeatmapSet() {
        return beatmapset;
    }

    @Override
    public UserCompact getUser() {
        return user;
    }

    @Nullable
    @Override
    public Object getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "ScoreImpl{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", username=" + getUsername() +
                ", beatmapId=" + getBeatmapId() +
                ", maxCombo=" + maxCombo +
                ", pp=" + pp +
                ", rank='" + rank + '\'' +
                '}';
    }
}
