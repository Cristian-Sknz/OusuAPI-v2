package me.skiincraft.api.osu.object.score;

import com.google.gson.annotations.SerializedName;

public class ScoreStatistics {

    @SerializedName("count_50")
    private final int s50;
    @SerializedName("count_100")
    private final int s100;
    @SerializedName("count_300")
    private final int s300;
    @SerializedName("count_geki")
    private final int geki;
    @SerializedName("count_katu")
    private final int katu;
    @SerializedName("count_miss")
    private final int miss;

    public ScoreStatistics(int s50, int s100, int s300, int geki, int katu, int miss) {
        this.s50 = s50;
        this.s100 = s100;
        this.s300 = s300;
        this.geki = geki;
        this.katu = katu;
        this.miss = miss;
    }

    public int get50() {
        return s50;
    }

    public int get100() {
        return s100;
    }

    public int get300() {
        return s300;
    }

    public int getGeki() {
        return geki;
    }

    public int getKatu() {
        return katu;
    }

    public int getMiss() {
        return miss;
    }

}
