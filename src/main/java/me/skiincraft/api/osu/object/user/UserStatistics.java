package me.skiincraft.api.osu.object.user;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class UserStatistics {

    private final Map<String, Integer> level;
    private final float pp;
    @SerializedName(value = "hit_accuracy", alternate = {"accuracy"})
    private final float hitAccuracy;
    @SerializedName("pp_rank")
    private final int ppRank;
    @SerializedName("ranked_score")
    private final long rankedScore;
    @SerializedName(value = "play_count", alternate = {"playcount"})
    private final long playCount;
    @SerializedName(value = "play_time", alternate = {"total_seconds_played"})
    private final long playTime;
    @SerializedName("total_score")
    private final long totalScore;
    @SerializedName("total_hits")
    private final long totalHits;
    @SerializedName("maximum_combo")
    private final Long maxCombo;
    @SerializedName("replays_watched_by_others")
    private final Long replaysWatcheds;
    @SerializedName("is_ranked")
    private final boolean isRanked;
    @SerializedName("grade_count")
    private final Grade grade;
    private final Map<String, Integer> rank;

    public UserStatistics(Map<String, Integer> level, float pp, float hitAccuracy, int ppRank, long rankedScore, long playCount, long playTime, long totalScore, long totalHits, long maxCombo, long replaysWatchds, boolean isRanked, Grade grade, Map<String, Integer> rank) {
        this.level = level;
        this.pp = pp;
        this.hitAccuracy = hitAccuracy;
        this.ppRank = ppRank;
        this.rankedScore = rankedScore;
        this.playCount = playCount;
        this.playTime = playTime;
        this.totalScore = totalScore;
        this.totalHits = totalHits;
        this.maxCombo = maxCombo;
        this.replaysWatcheds = replaysWatchds;
        this.isRanked = isRanked;
        this.grade = grade;
        this.rank = rank;
    }

    public UserStatistics(int levelInt, float pp, float hitAccuracy, int ppRank, long rankedScore, long playCount, long playTime, long totalScore, long totalHits, Long maxCombo, Long replaysWatchds, boolean isRanked, Grade grade, int ppCountry) {
        this.level = new HashMap<>();
        level.put("current", levelInt);
        level.put("progress", 0);
        this.pp = pp;
        this.hitAccuracy = hitAccuracy;
        this.ppRank = ppRank;
        this.rankedScore = rankedScore;
        this.playCount = playCount;
        this.playTime = playTime;
        this.totalScore = totalScore;
        this.totalHits = totalHits;
        this.maxCombo = maxCombo;
        this.replaysWatcheds = replaysWatchds;
        this.isRanked = isRanked;
        this.grade = grade;
        this.rank = new HashMap<>();
        rank.put("global", ppRank);
        rank.put("country", ppCountry);
    }

    public int getCurrentLevel() {
        return level.get("current");
    }

    public int getProgressLevel() {
        return level.get("progress");
    }

    public float getPp() {
        return pp;
    }

    public float getHitAccuracy() {
        return hitAccuracy;
    }

    public int getPpRank() {
        return ppRank;
    }

    public long getRankedScore() {
        return rankedScore;
    }

    public long getPlayCount() {
        return playCount;
    }

    public long getPlayTime() {
        return playTime;
    }

    public long getTotalScore() {
        return totalScore;
    }

    public long getTotalHits() {
        return totalHits;
    }

    @Nullable
    public Long getMaxCombo() {
        return maxCombo;
    }

    @Nullable
    public Long getReplaysWatcheds() {
        return replaysWatcheds;
    }

    public boolean isRanked() {
        return isRanked;
    }

    public Grade getGrade() {
        return grade;
    }

    public long getGlobalRank() {
        return rank.get("global");
    }

    public long getCountryRank() {
        return rank.get("country");
    }
}
