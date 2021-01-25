package me.skiincraft.api.osu.impl.v1.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapImpl;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapSetCompactImpl;
import me.skiincraft.api.osu.object.beatmap.Covers;
import me.skiincraft.api.osu.object.beatmap.FailTimes;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class BeatmapV1Impl extends BeatmapImpl implements Beatmap {

    private final String title;
    @SerializedName("title_unicode")
    private final String titleUnicode;
    private final String artist;
    @SerializedName("artist_unicode")
    private final String artistUnicode;
    @SerializedName("creator")
    private final String creator;
    @SerializedName("creator_id")
    private final long creatorId;
    @SerializedName("favourite_count")
    private final long favourites;

    private final int video;
    private final String source;

    // Off
    @SerializedName("download_unavailable")
    private final int downloadDisabled;
    private final int storyboard;
    @SerializedName("approved_date")
    private final String rankedDate;
    @SerializedName("submit_date")
    private final String submitDate;
    private final String tags;
    private final int genre;
    @SerializedName("language_id")
    private final int language;

    public BeatmapV1Impl(float difficultRating, long beatmapId, int gamemodeId, int totalLength, String version, float accuracy, int ar, int bpm, int circles, int sliders, int spinners, int maxCombo, int drain, int hitlength, long beatmapSetId, long passcount, long playcount, boolean convert, boolean isScoreable, float cs, String deletedat, String lastUpdated, int status, FailTimes failtimes, BeatmapSetCompactImpl beatmapset, String title, String titleUnicode, String artist, String artistUnicode, String creator, long creatorId, long favourites, int video, String source, int downloadDisabled, int storyboard, String rankedDate, String submitDate, String tags, int genre, int language) {
        super(difficultRating, beatmapId, gamemodeId, totalLength, version, accuracy, ar, bpm, circles, sliders, spinners, maxCombo, drain, hitlength, beatmapSetId, passcount, playcount, convert, isScoreable, cs, deletedat, lastUpdated, status, failtimes, beatmapset);
        this.title = title;
        this.titleUnicode = titleUnicode;
        this.artist = artist;
        this.artistUnicode = artistUnicode;
        this.creator = creator;
        this.creatorId = creatorId;
        this.favourites = favourites;
        this.video = video;
        this.source = source;
        this.downloadDisabled = downloadDisabled;
        this.storyboard = storyboard;
        this.rankedDate = rankedDate;
        this.submitDate = submitDate;
        this.tags = tags;
        this.genre = genre;
        this.language = language;
    }

    @Override
    public BeatmapSetCompact getBeatmapSet() {
        return new BeatmapSetCompactImpl(title, artist, titleUnicode, artistUnicode, creator, creatorId, getBeatmapSetId(), getPassCount(), getGenre().getId(), getLanguage().getId(), toString(getRankedDate()), toString(getSubmitDate()), favourites, getBPM(), video == 1, new Covers(getBeatmapSetId()), source, getStatus().getId(), new long[0]);
    }

    public int getDownloadDisabled() {
        return downloadDisabled;
    }

    public int getStoryboard() {
        return storyboard;
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return (getLastUpdatedString() == null) ? null : LocalDateTime.parse(getLastUpdatedString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atOffset(ZoneOffset.UTC);
    }

    public OffsetDateTime getRankedDate() {
        return (rankedDate == null) ? null : LocalDateTime.parse(rankedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atOffset(ZoneOffset.UTC);
    }

    public OffsetDateTime getSubmitDate() {
        return (submitDate == null) ? null : LocalDateTime.parse(submitDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atOffset(ZoneOffset.UTC);
    }

    private <T> String toString(T t) {
        if (t == null) {
            return null;
        }
        return t.toString();
    }

    public String getTags() {
        return tags;
    }

    public Genre getGenre() {
        return Genre.getById(genre);
    }

    public Language getLanguage() {
        return Language.getById(language);
    }


}
