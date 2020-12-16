package me.skiincraft.api.osu.object.score;

public enum ScoreType {

    BEST, FIRSTS, RECENT;

    public String getNameToLowerCase(){
        return name().toLowerCase();
    }
}
