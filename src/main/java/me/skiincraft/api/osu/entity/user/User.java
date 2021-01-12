package me.skiincraft.api.osu.entity.user;


import me.skiincraft.api.osu.object.user.*;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public interface User extends SimpleUser, UserCompact {

    Cover getCover();

    String getCoverURL();

    UserStatistics getStatistics();

    OffsetDateTime getLastVisit();

    OffsetDateTime getJoinDate();

    String[] getPreviousUsernames();

    int getSupportLevel(); //

    boolean hasPMFriendsOnly(); //

    boolean hasSupported(); //

    @Nullable
    String getDiscord(); //

    @Nullable
    String getInterests();

    @Nullable
    String getLocation();

    @Nullable
    String getOccupation();

    @Nullable
    String getTwitter();

    @Nullable
    String getSkype();

    @Nullable
    String getTitle();

    @Nullable
    String getTitleURL();

    @Nullable
    String getWebsite();

    @Nullable
    PlayStyle[] getPlayStyles();

    TournamentBanner[] getTournamentBanner();

    List<Badge> getBadges();

    long getTotalKudosu();

    long getAvailableKudosu();

    int getMaxBlocks();

    int getMaxFriends();

    int getCommentsSize();

    int getFollowersCount();

    int getBeatmapPlayCounts();

    int getClassifiableBeatmaps();

    int getFavouriteBeatmaps();

    int getGraveyardBeatmaps();

    int getLovedBeatmaps();

    int getUnrankedBeatmaps();

    int getScoresBest();

    int getScoresFirst();

    int getScoresRecent();

    List<Count> getMonthlyPlays();

    default long getTotalMonthlyPlays() {
        return getMonthlyPlays().stream().mapToLong(Count::getCount).sum();
    }

    List<Count> getReplaysWatched();

    default long getTotalReplaysWatched() {
        return getReplaysWatched().stream().mapToLong(Count::getCount).sum();
    }

    @Nullable
    default Locale getCountry() {
        return Arrays.stream(Locale.getAvailableLocales()).filter(locale -> locale.getCountry().equals(getCountryCode())).findFirst().orElse(null);
    }

    /* JsonArray<?> getAccountHistory() -> "account_history"*/
    /* JsonArray<?> getGroups()-> "groups"*/
    /* JsonObject<?> getPage() -> "page"*/
}
