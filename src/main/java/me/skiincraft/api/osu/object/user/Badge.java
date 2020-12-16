package me.skiincraft.api.osu.object.user;

import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;

public class Badge {

    @SerializedName("awarded_at")
    private final String awardedAt;
    private final String description;
    @SerializedName("image_url")
    private final String image;
    private final String url;

    public Badge(String awardedAt, String description, String image, String url) {
        this.awardedAt = awardedAt;
        this.description = description;
        this.image = image;
        this.url = url;
    }

    public OffsetDateTime getAwardDate() {
        return (awardedAt == null) ? null : OffsetDateTime.parse(awardedAt);
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
