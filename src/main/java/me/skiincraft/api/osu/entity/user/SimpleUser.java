package me.skiincraft.api.osu.entity.user;

import me.skiincraft.api.osu.object.user.UserStatistics;

import java.time.OffsetDateTime;

public interface SimpleUser extends UserCompact {

    OffsetDateTime getJoinDate();

    UserStatistics getStatistics();

    boolean isCompleteUser();

    default User getUser() {
        if (isCompleteUser()) {
            return (User) this;
        }
        throw new UnsupportedOperationException("This method is not compatible with this version of the API");
    }

}
