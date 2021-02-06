package me.skiincraft.api.osu.object.game;

import javax.annotation.Nullable;
import java.util.Arrays;

public enum GameMode {

    Osu(0, "standard", "default", "osu!"),
    Taiko(1, "taiko", "osu!taiko"),
    Mania(2, "mania", "osu!mania"),
    Fruits(3, "catch", "osu!catch", "osu!fruits");

    private final int id;
    private final String[] alternate;

    GameMode(int id, String... alternate) {
        this.id = id;
        this.alternate = alternate;
    }

    @Nullable
    public static GameMode byInt(int id) {
        return Arrays.stream(values()).filter(gm -> gm.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Nullable
    public static GameMode byName(String name) {
        if (name.length() == name.replaceAll("\\D+", "").length()) {
            return byInt(Integer.parseInt(name));
        }
        return Arrays.stream(values()).filter(gm -> gm.name().equalsIgnoreCase(name) ||
                Arrays.stream(gm.alternate).anyMatch(alt -> alt.equalsIgnoreCase(name)))
                .findFirst()
                .orElse(null);
    }

    public String[] getAlternate() {
        return alternate;
    }

    public int getId() {
        return id;
    }
}
