package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.Covers;

import javax.annotation.Nullable;

public interface BeatmapSetCompact {

    String getTitle();

    String getTitleUnicode(); //

    String getArtist();

    String getArtistUnicode(); //

    String getCreator();

    long getUserId(); //

    long getBeatmapSetId(); //

    long getPlayCount(); //

    long getFavourites(); //

    float getBPM();

    boolean hasVideo();

    Covers getCovers();

    @Nullable
    String getSource();

    Approval getStatus(); //

    long[] getRatings();

    default String getPreviewURL() {
        return String.format("http://b.ppy.sh/preview/%s.mp3", getBeatmapSetId());
    }

    default String getURL() {
        return String.format("https://osu.ppy.sh/beatmapsets/%s", getBeatmapSetId());
    }

}
