package me.skiincraft.api.osu.object.beatmap;

import java.util.Arrays;

public enum Genre {

    Any(0, "Any"),
    Unspecified(1, "Unspecified"),
    Video_Game(2, "Video Game"),
    Anime(3, "Anime"),
    Rock(4, "Rock"),
    Pop(5, "Pop"),
    Other(6, "Other"),
    Novelty(7, "Novelty"),
    Hip_Hop(9, "Hip Hop"),
    Electronic(10, "Electronic"),
    Metal(11, "Metal"),
    Classic(12, "Classic"),
    Popular_Music(13, "Popular Music"),
    Jazz(14, "Jazz");

    private final int id;
    private final String name;

    Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Genre getById(int id) {
        return Arrays.stream(values()).filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
