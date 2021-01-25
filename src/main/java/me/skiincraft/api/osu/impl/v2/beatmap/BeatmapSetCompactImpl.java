package me.skiincraft.api.osu.impl.v2.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.Covers;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;

public class BeatmapSetCompactImpl implements BeatmapSetCompact {

    private final String title;
    private final String artist;
    @SerializedName("title_unicode")
    private final String titleUnicode;
    @SerializedName("artist_unicode")
    private final String artistUnicode;
    private final String creator;

    @SerializedName("user_id")
    private final long userId;
    @SerializedName("id")
    private final long beatmapSetId;
    private final long playcount;
    @SerializedName("ranked_date")
    private final String rankedDate;
    @SerializedName("submitted_date")
    private final String submittedDate;
    @SerializedName("favourite_count")
    private final long favourites;
    private final float bpm;
    private final boolean video;
    private final Covers covers;
    private final String source;
    @SerializedName("ranked")
    private final int status;
    private final long[] ratings;
    @SerializedName("genre_id")
    private final int genreId;
    @SerializedName("language_id")
    private final int languageId;

    public BeatmapSetCompactImpl(BeatmapSetCompact compact) {
        this.title = compact.getTitle();
        this.artist = compact.getArtist();
        this.titleUnicode = compact.getTitleUnicode();
        this.artistUnicode = compact.getArtistUnicode();
        this.creator = compact.getCreator();
        this.userId = compact.getUserId();
        this.beatmapSetId = compact.getBeatmapSetId();
        this.playcount = compact.getPlayCount();
        this.genreId = compact.getGenre().getId();
        this.languageId = compact.getLanguage().getId();
        this.rankedDate = (compact.getRankedDate() == null) ? null : compact.getRankedDate().toString();
        this.submittedDate = (compact.getSubmittedDate() == null) ? null : compact.getSubmittedDate().toString();
        this.favourites = compact.getFavourites();
        this.bpm = compact.getBPM();
        this.video = compact.hasVideo();
        this.covers = compact.getCovers();
        this.source = compact.getSource();
        this.status = compact.getStatus().getId();
        this.ratings = compact.getRatings();
    }

    public BeatmapSetCompactImpl(String title, String artist, String titleUnicode, String artistUnicode, String creator, long userId, long beatmapSetId, long playcount, int genre, int language, String rankedDate, String submittedDate, long favourites, float bpm, boolean video, Covers covers, String source, int status, long[] ratings) {
        this.title = title;
        this.artist = artist;
        this.titleUnicode = titleUnicode;
        this.artistUnicode = artistUnicode;
        this.creator = creator;
        this.userId = userId;
        this.beatmapSetId = beatmapSetId;
        this.playcount = playcount;
        this.genreId = genre;
        this.languageId = language;
        this.rankedDate = rankedDate;
        this.submittedDate = submittedDate;
        this.favourites = favourites;
        this.bpm = bpm;
        this.video = video;
        this.covers = covers;
        this.source = source;
        this.status = status;
        this.ratings = ratings;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getTitleUnicode() {
        return titleUnicode;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public String getArtistUnicode() {
        return artistUnicode;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public long getBeatmapSetId() {
        return beatmapSetId;
    }

    @Override
    public long getPlayCount() {
        return playcount;
    }

    @Override
    public long getFavourites() {
        return favourites;
    }

    @Override
    public float getBPM() {
        return bpm;
    }

    @Override
    public boolean hasVideo() {
        return video;
    }

    @Override
    public Covers getCovers() {
        return covers;
    }

    @Override
    public Genre getGenre() {
        return Genre.getById(genreId);
    }

    @Override
    public Language getLanguage() {
        return Language.getById(languageId);
    }

    @Nullable
    @Override
    public String getSource() {
        return source;
    }

    @Override
    public Approval getStatus() {
        return Approval.getById(status);
    }

    @Override
    public long[] getRatings() {
        return ratings;
    }

    @Nullable
    @Override
    public OffsetDateTime getRankedDate() {
        return (rankedDate == null) ? null : OffsetDateTime.parse(rankedDate);
    }

    @Nullable
    @Override
    public OffsetDateTime getSubmittedDate() {
        return (submittedDate == null) ? null : OffsetDateTime.parse(submittedDate);
    }


    @Override
    public String toString() {
        return "BeatmapSetCompact{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", beatmapSetId=" + beatmapSetId +
                ", creator='" + creator + '\'' +
                ", status=" + getStatus() +
                ", userId=" + userId +
                ", bpm=" + bpm +
                ", playcount=" + playcount +
                '}';
    }
}
