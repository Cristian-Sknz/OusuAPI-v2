package me.skiincraft.api.osu.object.ranking;

public enum RankingType {

    Charts("SpotLight"),
    Country("Country"),
    Performance("Performance"),
    Score("Score");

    private final String description;

    RankingType(String description) {
        this.description = description;
    }
}
