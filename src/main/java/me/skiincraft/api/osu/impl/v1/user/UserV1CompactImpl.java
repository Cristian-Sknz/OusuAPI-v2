package me.skiincraft.api.osu.impl.v1.user;

import com.google.gson.annotations.SerializedName;
import me.skiincraft.api.osu.impl.v2.user.UserCompactImpl;

public class UserV1CompactImpl extends UserCompactImpl {

    @SerializedName(value = "country")
    private final String countryCode;

    public UserV1CompactImpl(long id, String username, String profileColour, String avatarUrl, String countryCode, boolean isActive, boolean isBot, boolean isOnline, boolean isSupporter) {
        super(id, username, profileColour, avatarUrl, countryCode, isActive, isBot, isOnline, isSupporter);
        this.countryCode = countryCode;
    }

    @Override
    public String getCountryCode() {
        return countryCode;
    }
}
