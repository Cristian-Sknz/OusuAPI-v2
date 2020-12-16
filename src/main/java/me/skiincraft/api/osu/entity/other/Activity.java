package me.skiincraft.api.osu.entity.other;

import java.time.OffsetDateTime;

public interface Activity {

    OffsetDateTime getCreatedDate();

    long getActivityId();

    ActivityType getType();

    String getUsername();

    long getUserId();

    /*
    ActivityObject getActivityObject()
    class ActivityObject {

    }
     */

    enum ActivityType {
        Achievement("achievement"),
        BeatmapSetApprove("beatmapsetApprove"),
        BeatmapSetUpdate("beatmapsetUpdate"),
        SupportGift("userSupportGift"),
        RankLost("rankLost"),
        Rank("rank"),
        Other("other");


        private final String name;

        ActivityType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
