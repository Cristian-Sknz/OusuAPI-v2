package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.entity.user.UserCompact;
import me.skiincraft.api.osu.object.beatmap.Genre;
import me.skiincraft.api.osu.object.beatmap.Language;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;

public interface BeatmapSet extends BeatmapSetCompact {

    /* <?> getHype();*/
    boolean canBeHyped(); //

    boolean hasDownloadDisabled(); //

    boolean hasDiscussionEnabled(); //

    boolean hasDiscussionLocked(); //

    boolean hasStoryboard();

    boolean isScoreable();//

    OffsetDateTime getLastUpdated(); //

    @Nullable
    String getLegacyThreadUrl(); //

    @Nullable
    OffsetDateTime getRankedDate(); //

    @Nullable
    OffsetDateTime getSubmittedDate(); //

    String getTags();

    List<Beatmap> getBeatmaps();

    List<Beatmap> getConverts();

    String getDescription();

    Genre getGenre(); //

    Language getLanguage();

    List<UserCompact> getRecentFavourites();

    UserCompact getUser();

    int getNominationsCurrent(); //

    int getNominationsRequired(); //


}
