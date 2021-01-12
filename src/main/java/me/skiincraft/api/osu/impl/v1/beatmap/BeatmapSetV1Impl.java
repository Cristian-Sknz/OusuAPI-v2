package me.skiincraft.api.osu.impl.v1.beatmap;

import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.impl.v2.beatmap.BeatmapSetCompactImpl;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

public class BeatmapSetV1Impl extends BeatmapSetCompactImpl implements BeatmapSet {

    private final BeatmapV1Impl[] beatmaps;

    public BeatmapSetV1Impl(BeatmapV1Impl[] beatmaps) {
        super(beatmaps[0].getBeatmapSet());
        this.beatmaps = beatmaps;
    }

    @Override
    public Boolean canBeHyped() {
        return null;
    }

    @Override
    public boolean hasDownloadDisabled() {
        return beatmaps[0].getDownloadDisabled() == 1;
    }

    @Override
    public Boolean hasDiscussionEnabled() {
        return null;
    }

    @Override
    public Boolean hasDiscussionLocked() {
        return null;
    }

    @Override
    public boolean hasStoryboard() {
        return beatmaps[0].getStoryboard() == 1;
    }

    @Override
    public boolean isScoreable() {
        return beatmaps[0].getStatus().isScoreable();
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return beatmaps[0].getLastUpdated();
    }

    @Override
    public String getLegacyThreadUrl() {
        return null;
    }

    @Nullable
    @Override
    public OffsetDateTime getRankedDate() {
        return beatmaps[0].getRankedDate();
    }

    @Nullable
    @Override
    public OffsetDateTime getSubmittedDate() {
        return beatmaps[0].getSubmitDate();
    }

    @Override
    public String getTags() {
        return beatmaps[0].getTags();
    }

    @Override
    public List<Beatmap> getBeatmaps() {
        return Arrays.asList(beatmaps);
    }

    @Override
    public List<Beatmap> getConverts() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Genre getGenre() {
        return beatmaps[0].getGenre();
    }

    @Override
    public Language getLanguage() {
        return beatmaps[0].getLanguage();
    }

    @Override
    public List<UserCompact> getRecentFavourites() {
        return null;
    }

    @Override
    public UserCompact getUser() {
        return null;
    }

    @Override
    public Integer getNominationsCurrent() {
        return null;
    }

    @Override
    public Integer getNominationsRequired() {
        return null;
    }

    @Override
    public String toString() {
        return "BeatmapSet{" +
                "title='"  + getTitle() + '\''+
                ", artist='" + getArtist() + '\'' +
                ", beatmapSetId=" + getBeatmapSetId() +
                ", creator='" + getCreator() + '\'' +
                ", status=" + getStatus() +
                ", userId=" + getUserId() +
                ", bpm=" + getBPM() +
                ", playcount=" + getPlayCount() +
                ", beatmaps=" + Arrays.toString(beatmaps) +
                "}";
    }
}
