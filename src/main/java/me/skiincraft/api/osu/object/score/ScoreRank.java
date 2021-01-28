package me.skiincraft.api.osu.object.score;

import java.util.Arrays;

public enum ScoreRank {

    SSh("SSh", "XH"),
    SS("SS", "X"),
    Sh("SH"),
    S("S"),
    A("A"),
    B("B"),
    C("C"),
    F("F");

    private String name;
    private String[] alternate;

    ScoreRank(String name, String... alternate) {
        this.name = name;
        this.alternate = alternate;
    }

    public String getName() {
        return name;
    }

    public String[] getAlternate() {
        return alternate;
    }

    public static ScoreRank getScore(String rank){
        return Arrays.stream(values()).filter(score -> score.getName().equalsIgnoreCase(rank) || Arrays.stream(score.getAlternate()).anyMatch(alternate -> alternate.equalsIgnoreCase(rank))).findFirst().orElse(null);
    }
}
