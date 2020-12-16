package me.skiincraft.api.osu.object.user;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class UserStatistics {

    private final Map<String, Integer> level;
    private final float pp;
    @SerializedName("hit_accuracy")
    private final float hitAccuracy;
    @SerializedName("pp_rank")
    private final int ppRank;
    @SerializedName("ranked_score")
    private final long rankedScore;
    @SerializedName("play_count")
    private final long playCount;
    @SerializedName("play_time")
    private final long playTime;
    @SerializedName("total_score")
    private final long totalScore;
    @SerializedName("total_hits")
    private final long totalHits;
    @SerializedName("maximum_combo")
    private final long maxCombo;
    @SerializedName("replays_watched_by_others")
    private final long replaysWatchds;
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
        this.replaysWatchds = replaysWatchds;
        this.isRanked = isRanked;
        this.grade = grade;
        this.rank = rank;
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

    public long getMaxCombo() {
        return maxCombo;
    }

    public long getReplaysWatchds() {
        return replaysWatchds;
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
