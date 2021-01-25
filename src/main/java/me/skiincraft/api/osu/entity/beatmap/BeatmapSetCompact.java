package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.Covers;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.OffsetDateTime;

public interface BeatmapSetCompact {

    String getTitle();

    String getTitleUnicode();

    String getArtist();

    String getArtistUnicode();

    String getCreator();

    long getUserId();

    long getBeatmapSetId();

    long getPlayCount();

    long getFavourites();

    float getBPM();

    boolean hasVideo();

    Covers getCovers();

    @Nullable
    String getSource();

    Approval getStatus();

    default Genre getGenre() {
        return Genre.Unspecified;
    }

    default Language getLanguage() {
        return Language.Unspecified;
    }

    long[] getRatings();

    @Nullable
    OffsetDateTime getRankedDate();

    @Nullable
    OffsetDateTime getSubmittedDate();

    default String getPreviewURL() {
        return String.format("http://b.ppy.sh/preview/%s.mp3", getBeatmapSetId());
    }

    default InputStream getPreview() throws IOException {
        try {
            URLConnection connection = new URL(getPreviewURL()).openConnection();
            return connection.getInputStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    default String getURL() {
        return String.format("https://osu.ppy.sh/beatmapsets/%s", getBeatmapSetId());
    }

}
