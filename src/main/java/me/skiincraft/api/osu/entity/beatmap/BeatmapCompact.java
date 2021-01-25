package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.object.game.GameMode;

import java.text.DecimalFormat;
import java.util.Arrays;

public interface BeatmapCompact extends Comparable<BeatmapCompact> {

    float getDifficultyRating();

    default String getDifficultRatingStars() {
        String difficultRating = String.valueOf(new DecimalFormat("#.0").format(getDifficultyRating()));
        Integer[] itens = Arrays.stream(((difficultRating.contains("."))
                ? difficultRating.split("\\.")
                : difficultRating.split(","))).map(Integer::new).toArray(Integer[]::new);

        StringBuilder starsBuilder = new StringBuilder();
        for (int i = 0; i < itens[0]; i++) {
            starsBuilder.append("★");
        }
        if (itens[1] >= 5) {
            return "**" + starsBuilder.toString() + "✩** (" + difficultRating + ")";
        } else {
            return "**" + starsBuilder.toString() + "** (" + difficultRating + ")";
        }
    }

    long getBeatmapId();

    GameMode getGameMode();

    int getTotalLength();

    String getVersion();

    default String getURL() {
        return "https://osu.ppy.sh/beatmaps/" + getBeatmapId();
    }

    @Override
    default int compareTo(BeatmapCompact o) {
        return Float.compare(getDifficultyRating(), o.getDifficultyRating());
    }

}
