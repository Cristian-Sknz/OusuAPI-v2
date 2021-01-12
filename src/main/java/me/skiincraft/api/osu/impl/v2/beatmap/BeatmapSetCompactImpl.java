package me.skiincraft.api.osu.impl.v2.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.BeatmapCompact;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSetCompact;
import me.skiincraft.api.osu.object.beatmap.Approval;
import me.skiincraft.api.osu.object.beatmap.Covers;

import javax.annotation.Nullable;

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

    @SerializedName("favourite_count")
    private final long favourites;
    private final float bpm;
    private final boolean video;
    private final Covers covers;

    private final String source;
    @SerializedName("ranked")
    private final int status;
    private final long[] ratings;

    public BeatmapSetCompactImpl(BeatmapSetCompact compact){
        this.title = compact.getTitle();
        this.artist = compact.getArtist();
        this.titleUnicode = compact.getTitleUnicode();
        this.artistUnicode = compact.getArtistUnicode();
        this.creator = compact.getCreator();
        this.userId = compact.getUserId();
        this.beatmapSetId = compact.getBeatmapSetId();
        this.playcount = compact.getPlayCount();
        this.favourites = compact.getFavourites();
        this.bpm = compact.getBPM();
        this.video = compact.hasVideo();
        this.covers = compact.getCovers();
        this.source = compact.getSource();
        this.status = compact.getStatus().getId();
        this.ratings = compact.getRatings();
    }

    public BeatmapSetCompactImpl(String title, String artist, String titleUnicode, String artistUnicode, String creator, long userId, long beatmapSetId, long playcount, long favourites, float bpm, boolean video, Covers covers, String source, int status, long[] ratings) {
        this.title = title;
        this.artist = artist;
        this.titleUnicode = titleUnicode;
        this.artistUnicode = artistUnicode;
        this.creator = creator;
        this.userId = userId;
        this.beatmapSetId = beatmapSetId;
        this.playcount = playcount;
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
