package me.skiincraft.api.osu.entity.beatmap;

import me.skiincraft.api.osu.entity.user.UserCompact;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.List;

public interface BeatmapSet extends BeatmapSetCompact {

    /* <?> getHype();*/
    @Nullable
    Boolean canBeHyped(); //

    boolean hasDownloadDisabled();

    @Nullable
    Boolean hasDiscussionEnabled(); //

    @Nullable
    Boolean hasDiscussionLocked(); //

    boolean hasStoryboard();

    boolean isScoreable();

    OffsetDateTime getLastUpdated();

    @Nullable
    String getLegacyThreadUrl(); //

    String getTags();

    List<Beatmap> getBeatmaps();

    @Nullable
    List<Beatmap> getConverts(); //

    @Nullable
    String getDescription(); //

    @Nullable
    List<UserCompact> getRecentFavourites(); //

    @Nullable
    UserCompact getUser(); //

    @Nullable
    Integer getNominationsCurrent(); //

    @Nullable
    Integer getNominationsRequired(); //


}
