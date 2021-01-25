package me.skiincraft.api.osu.object.game;

import javax.annotation.Nullable;
import java.util.Arrays;

public enum GameMode {

    Osu(0, "osu!standard"),
    Taiko(1, "osu!taiko"),
    Mania(2, "osu!mania"),
    Fruits(3, "osu!catch");

    private final int id;
    private final String description;

    GameMode(int id, String description) {
        this.id = id;
        this.description = description;
    }

    @Nullable
    public static GameMode byInt(int id) {
        return Arrays.stream(values()).filter(gm -> gm.getId() == id).findFirst().orElse(null);
    }

    @Nullable
    public static GameMode byName(String name) {
        if (name.length() == name.replaceAll("\\D+", "").length()) {
            return byInt(Integer.parseInt(name));
        }
        return Arrays.stream(values()).filter(gm -> gm.name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }
}
