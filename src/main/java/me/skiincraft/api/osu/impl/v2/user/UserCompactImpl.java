package me.skiincraft.api.osu.impl.v2.user;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.entity.user.UserCompact;

import java.awt.*;

public class UserCompactImpl implements UserCompact {

    @SerializedName(value = "user_id", alternate = "id")
    private final long id;
    @SerializedName("username")
    private final String username;
    @SerializedName("profile_colour")
    private final String profileColour; //
    @SerializedName("avatar_url")
    private final String avatarUrl; //
    @SerializedName(value = "country_code")
    private final String countryCode;
    @SerializedName("is_active")
    private final boolean isActive; //
    @SerializedName("is_bot")
    private final boolean isBot; //
    @SerializedName("is_online")
    private final boolean isOnline; //
    @SerializedName("is_supporter")
    private final boolean isSupporter; //

    public UserCompactImpl(long id, String username, String profileColour, String avatarUrl, String countryCode, boolean isActive, boolean isBot, boolean isOnline, boolean isSupporter) {
        this.id = id;
        this.username = username;
        this.profileColour = profileColour;
        this.avatarUrl = avatarUrl;
        this.countryCode = countryCode;
        this.isActive = isActive;
        this.isBot = isBot;
        this.isOnline = isOnline;
        this.isSupporter = isSupporter;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Color getProfileColour() {
        return (profileColour == null) ? null : new Color(Integer.parseInt(profileColour.substring(1, 3), 16),
                Integer.parseInt(profileColour.substring(3, 5), 16),
                Integer.parseInt(profileColour.substring(5, 7), 16));
    }

    @Override
    public String getAvatarURL() {
        return ((avatarUrl.contains("avatar-guest"))? "https://osu.ppy.sh" : "") + avatarUrl;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public boolean isBot() {
        return isBot;
    }

    @Override
    public boolean isOnline() {
        return isOnline;
    }

    @Override
    public boolean isSupporter() {
        return isSupporter;
    }

    @Override
    public String toString() {
        return "UserCompact{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", isBot=" + isBot() +
                ", isOnline=" + isOnline() +
                ", isSupporter=" + isSupporter() +
                '}';
    }
}
