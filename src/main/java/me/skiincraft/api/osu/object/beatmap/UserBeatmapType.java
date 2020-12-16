package me.skiincraft.api.osu.object.beatmap;

public enum UserBeatmapType {

    FAVOURITE("favourite"),
    GRAVEYARD("graveyard"),
    LOVED("loved"),
    MOST_PLAYED("most_played"),
    CLASSIFIABLE("ranked_and_approved"),
    UNRANKED("unranked");

    private final String typeName;

    UserBeatmapType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
