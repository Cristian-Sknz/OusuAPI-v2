package me.skiincraft.api.osu.object.beatmap;

import java.util.Arrays;

public enum Language {

    Any(0),
    Unspecified(1),
    English(2),
    Japanese(3),
    Chinese(4),
    Instrumental(5),
    Korean(6),
    French(7),
    German(8),
    Swedish(9),
    Spanish(10),
    Italian(11),
    Russian(12),
    Polish(13),
    Other(14);

    private final int id;

    Language(int id) {
        this.id = id;
    }

    public static Language getById(int id) {
        return Arrays.stream(values()).filter(l -> l.getId() == id).findFirst().orElse(null);
    }

    public int getId() {
        return id;
    }
}
