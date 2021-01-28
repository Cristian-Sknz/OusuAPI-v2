package me.skiincraft.api.osu.impl.v2.beatmap;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.beatmap.Beatmap;
import me.skiincraft.api.osu.entity.beatmap.BeatmapSet;
import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.impl.v2.user.UserCompactImpl;
import me.skiincraft.api.osu.object.beatmap.Covers;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BeatmapSetImpl extends BeatmapSetCompactImpl implements BeatmapSet {

    @SerializedName("can_be_hyped")
    private final boolean canBeHyped;
    @SerializedName("availability")
    private final Map<String, String> downloaddisabled;
    private final boolean discussionenabled;
    private final boolean discussionlocked;
    private final boolean storyboard;
    @SerializedName("is_scoreable")
    private final boolean isScoreable;
    @SerializedName("last_updated")
    private final String lastUpdated;
    @SerializedName("legacy_thread_url")
    private final String legacyThreadUrl;
    private final String tags;

    private final BeatmapImpl[] beatmaps;
    private final BeatmapImpl[] converts;
    @SerializedName("description")
    private final Map<String, String> description;
    @SerializedName("genre")
    private final Map<String, String> genre;
    @SerializedName("language")
    private final Map<String, String> language;

    @SerializedName("recent_favourites")
    private final UserCompactImpl[] recentFavourites;
    private final UserCompactImpl user;

    @SerializedName("nominations_summary")
    private final Map<String, Integer> nominationsSummary;

    public BeatmapSetImpl(String title, String artist, String titleUnicode, String artistUnicode, String creator, long userId, long beatmapSetId, long playcount, int genreId, int languageId, long favourites, int bpm, boolean video, Covers covers, String source, int status, long[] ratings, boolean canBeHyped, Map<String, String> downloaddisabled, boolean discussionenabled, boolean discussionlocked, boolean storyboard, boolean isScoreable, String lastUpdated, String legacyThreadUrl, String rankedDate, String submittedDate, String tags, BeatmapImpl[] beatmaps, BeatmapImpl[] converts, Map<String, String> description, Map<String, String> genre, Map<String, String> language, UserCompactImpl[] recentFavourites, UserCompactImpl user, Map<String, Integer> nominationsSummary) {
        super(title, artist, titleUnicode, artistUnicode, creator, userId, beatmapSetId, playcount, genreId, languageId, rankedDate, submittedDate, favourites, bpm, video, covers, source, status, ratings);
        this.canBeHyped = canBeHyped;
        this.downloaddisabled = downloaddisabled;
        this.discussionenabled = discussionenabled;
        this.discussionlocked = discussionlocked;
        this.storyboard = storyboard;
        this.isScoreable = isScoreable;
        this.lastUpdated = lastUpdated;
        this.legacyThreadUrl = legacyThreadUrl;
        this.tags = tags;
        this.beatmaps = beatmaps;
        this.converts = converts;
        this.description = description;
        this.genre = genre;
        this.language = language;
        this.recentFavourites = recentFavourites;
        this.user = user;
        this.nominationsSummary = nominationsSummary;
    }

    @Override
    public Boolean canBeHyped() {
        return canBeHyped;
    }

    @Override
    public boolean hasDownloadDisabled() {
        return downloaddisabled.get("download_disabled").equalsIgnoreCase("true");
    }

    @Override
    public Boolean hasDiscussionEnabled() {
        return discussionenabled;
    }

    @Override
    public Boolean hasDiscussionLocked() {
        return discussionlocked;
    }

    @Override
    public boolean hasStoryboard() {
        return storyboard;
    }

    @Override
    public boolean isScoreable() {
        return isScoreable;
    }

    @Override
    public OffsetDateTime getLastUpdated() {
        return OffsetDateTime.parse(lastUpdated);
    }

    @Nullable
    @Override
    public String getLegacyThreadUrl() {
        return legacyThreadUrl;
    }

    @Override
    public String getTags() {
        return tags;
    }

    @Override
    public List<Beatmap> getBeatmaps() {
        return Arrays.stream(beatmaps).sorted().collect(Collectors.toList());
    }

    @Override
    public List<Beatmap> getConverts() {
        return Arrays.stream(converts).sorted().collect(Collectors.toList());
    }

    @Override
    public String getDescription() {
        return description.get("description");
    }

    @Override
    public Genre getGenre() {
        return Genre.getById((Objects.nonNull(genre)) ? Integer.parseInt(genre.get("id")): 1);
    }

    @Override
    public Language getLanguage() {
        return Language.getById((Objects.nonNull(language)) ? Integer.parseInt(language.get("id")): 1);
    }

    @Override
    public List<UserCompact> getRecentFavourites() {
        return new ArrayList<>(Arrays.asList(recentFavourites));
    }

    @Override
    public UserCompact getUser() {
        return user;
    }

    @Override
    public Integer getNominationsCurrent() {
        return nominationsSummary.get("current");
    }

    @Override
    public Integer getNominationsRequired() {
        return nominationsSummary.get("required");
    }

    @Override
    public String toString() {
        return "BeatmapSet{" +
                "title='" + getTitle() + '\'' +
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
