package me.skiincraft.api.osu.entity.user;

import javax.annotation.Nullable;
import java.awt.*;

public interface UserCompact {

    long getId();

    String getUsername();

    @Nullable
    Color getProfileColour();

    String getAvatarURL();

    String getCountryCode();

    boolean isActive();

    boolean isBot();

    boolean isOnline();

    boolean isSupporter();
}
