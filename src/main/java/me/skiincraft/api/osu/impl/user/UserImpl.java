package me.skiincraft.api.osu.impl.user;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.user.User;
import me.skiincraft.api.osu.object.user.*;

import javax.annotation.Nullable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserImpl extends UserCompactImpl implements User {

    @SerializedName("cover_url")
    private final String coverUrl;
    @SerializedName("pm_friends_only")
    private final boolean pmFriendsOnly;
    @SerializedName("has_supported")
    private final boolean hasSupported;
    @SerializedName("last_visit")
    private final String lastVisit;
    @SerializedName("join_date")
    private final String joinDate;

    private final String discord;
    private final String location;
    private final String occupation;
    private final String twitter;
    private final String skype;
    private final String interests;

    private final String title;
    @SerializedName("title_url")
    private final String titleUrl;
    private final String website;
    private final String[] playstyle;
    private final Cover cover;
    @SerializedName("active_tournament_banner")
    private final JsonElement tournamentBanner;
    private final Badge[] badges;
    private final Map<String, Long> kudosu;

    @SerializedName("max_blocks")
    private final int maxBlocks;
    @SerializedName("max_friends")
    private final int maxFriends;
    @SerializedName("comments_count")
    private final int commentsSize;
    @SerializedName("follower_count")
    private final int followersCount;

    @SerializedName("beatmap_playcounts_count")
    private final int beatmapPlayCounts;
    @SerializedName("ranked_and_approved_beatmapset_count")
    private final int classifiableBeatmaps;
    @SerializedName("favourite_beatmapset_count")
    private final int favouriteBeatmaps;
    @SerializedName("graveyard_beatmapset_count")
    private final int graveyardBeatmaps;
    @SerializedName("loved_beatmapset_count")
    private final int lovedBeatmaps;
    @SerializedName("unranked_beatmapset_count")
    private final int unrankedBeatmpas;

    @SerializedName("support_level")
    private final int supportLevel;

    @SerializedName("previous_usernames")
    private final String[] previousUsernames;
    private final UserStatistics statistics;

    @SerializedName("scores_best_count")
    private final int scoresBest;
    @SerializedName("scores_first_count")
    private final int scoresFirst;
    @SerializedName("scores_recent_count")
    private final int scoresRecent;

    @SerializedName("monthly_playcounts")
    private final Count[] monthlyPlays;
    @SerializedName("replays_watched_counts")
    private final Count[] replaysWatched;

    public UserImpl(long id, String username, String profileColour, String avatarUrl, String countryCode, boolean isActive, boolean isBot, boolean isOnline, boolean isSupporter, String coverUrl, boolean pmFriendsOnly, boolean hasSupported, String lastVisit, String joinDate, String discord, String location, String occupation, String twitter, String skype, String interests, String title, String titleUrl, String website, String[] playstyle, Cover cover, JsonElement tournamentBanner, Badge[] badges, Map<String, Long> kudosu, int maxBlocks, int maxFriends, int commentsSize, int followersCount, int beatmapPlayCounts, int classifiableBeatmaps, int favouriteBeatmaps, int graveyardBeatmaps, int lovedBeatmaps, int unrankedBeatmpas, int supportLevel, String[] previousUsernames, UserStatistics statistics, int scoresBest, int scoresFirst, int scoresRecent, Count[] monthlyPlays, Count[] replaysWatched) {
        super(id, username, profileColour, avatarUrl, countryCode, isActive, isBot, isOnline, isSupporter);
        this.coverUrl = coverUrl;
        this.pmFriendsOnly = pmFriendsOnly;
        this.hasSupported = hasSupported;
        this.lastVisit = lastVisit;
        this.joinDate = joinDate;
        this.discord = discord;
        this.location = location;
        this.occupation = occupation;
        this.twitter = twitter;
        this.skype = skype;
        this.interests = interests;
        this.title = title;
        this.titleUrl = titleUrl;
        this.website = website;
        this.playstyle = playstyle;
        this.cover = cover;
        this.tournamentBanner = tournamentBanner;
        this.badges = badges;
        this.kudosu = kudosu;
        this.maxBlocks = maxBlocks;
        this.maxFriends = maxFriends;
        this.commentsSize = commentsSize;
        this.followersCount = followersCount;
        this.beatmapPlayCounts = beatmapPlayCounts;
        this.classifiableBeatmaps = classifiableBeatmaps;
        this.favouriteBeatmaps = favouriteBeatmaps;
        this.graveyardBeatmaps = graveyardBeatmaps;
        this.lovedBeatmaps = lovedBeatmaps;
        this.unrankedBeatmpas = unrankedBeatmpas;
        this.supportLevel = supportLevel;
        this.previousUsernames = previousUsernames;
        this.statistics = statistics;
        this.scoresBest = scoresBest;
        this.scoresFirst = scoresFirst;
        this.scoresRecent = scoresRecent;
        this.monthlyPlays = monthlyPlays;
        this.replaysWatched = replaysWatched;
    }

    @Override
    public String getCoverURL() {
        return coverUrl;
    }

    @Override
    public boolean hasPMFriendsOnly() {
        return pmFriendsOnly;
    }

    @Override
    public boolean hasSupported() {
        return hasSupported;
    }

    @Override
    public OffsetDateTime getLastVisit() {
        return (lastVisit == null) ? null : OffsetDateTime.parse(lastVisit);
    }

    @Override
    public OffsetDateTime getJoinDate() {
        return (joinDate == null) ? null : OffsetDateTime.parse(joinDate);
    }

    @Nullable
    @Override
    public String getDiscord() {
        return discord;
    }

    @Nullable
    @Override
    public String getInterests() {
        return interests;
    }

    @Nullable
    @Override
    public String getLocation() {
        return location;
    }

    @Nullable
    @Override
    public String getOccupation() {
        return occupation;
    }

    @Nullable
    @Override
    public String getTwitter() {
        return twitter;
    }

    @Nullable
    @Override
    public String getSkype() {
        return skype;
    }

    @Nullable
    @Override
    public String getTitle() {
        return title;
    }

    @Nullable
    @Override
    public String getTitleURL() {
        return titleUrl;
    }

    @Nullable
    @Override
    public String getWebsite() {
        return website;
    }

    @Nullable
    @Override
    public PlayStyle[] getPlayStyles() {
        return Arrays.stream(PlayStyle.values()).filter(ps -> {
            for (String play : playstyle) {
                if (play.equalsIgnoreCase(ps.name())) {
                    return true;
                }
            }
            return false;
        }).toArray(PlayStyle[]::new);
    }

    @Override
    public Cover getCover() {
        return cover;
    }

    @Override
    public TournamentBanner[] getTournamentBanner() {
        Gson gson = new Gson();
        if (tournamentBanner.isJsonObject()) {
            return new TournamentBanner[]{gson.fromJson(tournamentBanner.getAsJsonObject(), TournamentBanner.class)};
        }
        if (tournamentBanner.isJsonArray() && tournamentBanner.getAsJsonArray().size() == 0) {
            return new TournamentBanner[0];
        }
        return gson.fromJson(tournamentBanner, TournamentBanner[].class);
    }

    @Override
    public List<Badge> getBadges() {
        return new ArrayList<>(Arrays.asList(badges));
    }

    @Override
    public long getTotalKudosu() {
        return kudosu.get("total");
    }

    @Override
    public long getAvailableKudosu() {
        return kudosu.get("available");
    }

    @Override
    public int getMaxBlocks() {
        return maxBlocks;
    }

    @Override
    public int getMaxFriends() {
        return maxFriends;
    }

    @Override
    public int getCommentsSize() {
        return commentsSize;
    }

    @Override
    public int getFollowersCount() {
        return followersCount;
    }

    @Override
    public int getBeatmapPlayCounts() {
        return beatmapPlayCounts;
    }

    @Override
    public int getClassifiableBeatmaps() {
        return classifiableBeatmaps;
    }

    @Override
    public int getFavouriteBeatmaps() {
        return favouriteBeatmaps;
    }

    @Override
    public int getGraveyardBeatmaps() {
        return graveyardBeatmaps;
    }

    @Override
    public int getLovedBeatmaps() {
        return lovedBeatmaps;
    }

    @Override
    public int getUnrankedBeatmaps() {
        return unrankedBeatmpas;
    }

    @Override
    public int getSupportLevel() {
        return supportLevel;
    }

    @Override
    public String[] getPreviousUsernames() {
        return previousUsernames;
    }

    @Override
    public UserStatistics getStatistics() {
        return statistics;
    }

    @Override
    public int getScoresBest() {
        return scoresBest;
    }

    @Override
    public int getScoresFirst() {
        return scoresFirst;
    }

    @Override
    public int getScoresRecent() {
        return scoresRecent;
    }

    @Override
    public List<Count> getMonthlyPlays() {
        return new ArrayList<>(Arrays.asList(monthlyPlays));
    }

    @Override
    public List<Count> getReplaysWatched() {
        return new ArrayList<>(Arrays.asList(replaysWatched));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
