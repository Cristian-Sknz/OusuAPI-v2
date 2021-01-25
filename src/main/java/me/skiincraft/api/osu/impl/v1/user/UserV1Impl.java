package me.skiincraft.api.osu.impl.v1.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.user.SimpleUser;
import me.skiincraft.api.osu.object.user.Grade;
import me.skiincraft.api.osu.object.user.UserStatistics;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class UserV1Impl extends UserV1CompactImpl implements SimpleUser {

    @SerializedName("join_date")
    private final String joinDate;

    private final long count300;
    private final long count100;
    private final long count50;
    private final long playcount;
    @SerializedName("ranked_score")
    private final long rankedScore;
    @SerializedName("total_score")
    private final long totalScore;
    @SerializedName("pp_rank")
    private final int ppRank;
    private final float level;
    @SerializedName("pp_raw")
    private final float pp;
    private final float accuracy;

    @SerializedName("count_rank_ss")
    private final int countSS;
    @SerializedName("count_rank_ssh")
    private final int countSSh;
    @SerializedName("count_rank_s")
    private final int countS;
    @SerializedName("count_rank_sh")
    private final int countSh;
    @SerializedName("count_rank_a")
    private final int countA;

    @SerializedName("total_seconds_played")
    private final long playtime;
    @SerializedName("pp_country_rank")
    private final int ppCountry;

    @Expose
    private UserStatistics userStatistics;

    public UserV1Impl(long id, String username, String profileColour, String avatarUrl, String countryCode, boolean isActive, boolean isBot, boolean isOnline, boolean isSupporter, String joinDate, long count300, long count100, long count50, long playcount, long rankedScore, long totalScore, int ppRank, float level, float pp, float accuracy, int countSS, int countSSh, int countS, int countSh, int countA, long playtime, int ppCountry) {
        super(id, username, profileColour, avatarUrl, countryCode, isActive, isBot, isOnline, isSupporter);
        this.joinDate = joinDate;
        this.count300 = count300;
        this.count100 = count100;
        this.count50 = count50;
        this.playcount = playcount;
        this.rankedScore = rankedScore;
        this.totalScore = totalScore;
        this.ppRank = ppRank;
        this.level = level;
        this.pp = pp;
        this.accuracy = accuracy;
        this.countSS = countSS;
        this.countSSh = countSSh;
        this.countS = countS;
        this.countSh = countSh;
        this.countA = countA;
        this.playtime = playtime;
        this.ppCountry = ppCountry;
    }

    @Override
    public boolean isActive() {
        return pp != 0;
    }

    public long getTotalHits() {
        return count50 + count100 + count300;
    }

    @Override
    public OffsetDateTime getJoinDate() {
        return LocalDateTime.parse(joinDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atOffset(ZoneOffset.UTC);
    }

    @Override
    public UserStatistics getStatistics() {
        return (userStatistics == null)
                ? userStatistics = new UserStatistics((int) level, pp, accuracy, ppRank, rankedScore, playcount, playtime,
                totalScore, getTotalHits(), null, null, isActive(),
                new Grade(countSS, countSSh, countS, countSh, countA), ppCountry, this)
                : userStatistics;
    }

    @Override
    public boolean isCompleteUser() {
        return false;
    }

    @Override
    public String toString() {
        return "SimpleUser{" +
                "user_id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", joinDate='" + getJoinDate() + '\'' +
                ", count300=" + count300 +
                ", count100=" + count100 +
                ", count50=" + count50 +
                ", playcount=" + playcount +
                ", rankedScore=" + rankedScore +
                ", totalScore=" + totalScore +
                ", ppRank=" + ppRank +
                ", level=" + level +
                ", pp=" + pp +
                ", accuracy=" + accuracy +
                ", countSS=" + getStatistics().getGrade().getSS() +
                ", countSSh=" + getStatistics().getGrade().getSsh() +
                ", countS=" + getStatistics().getGrade().getS() +
                ", countSh=" + getStatistics().getGrade().getSh() +
                ", countA=" + getStatistics().getGrade().getA() +
                ", playtime=" + playtime +
                ", ppCountry=" + ppCountry +
                "}";
    }
}
