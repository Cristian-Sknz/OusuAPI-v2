package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.object.game.GameMode;

public interface BeatmapCompact {

    float getDifficultyRating();

    long getBeatmapId();

    GameMode getGameMode();

    int getTotalLength();

    String getVersion();

    default String getURL() {
        return "https://osu.ppy.sh/beatmaps/" + getBeatmapId();
    }

}
