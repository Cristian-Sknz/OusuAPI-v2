package me.skiincraft.api.osu.object.ranking;

import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;

public class SpotLight {

    @SerializedName("end_date")
    private final String endDate;
    private final long id;
    @SerializedName("mode_specific")
    private final boolean modeSpecific;
    private final String name;
    @SerializedName("start_date")
    private final String startDate;
    private final String type;

    public SpotLight(String endDate, long id, boolean modeSpecific, String name, String startDate, String type) {
        this.endDate = endDate;
        this.id = id;
        this.modeSpecific = modeSpecific;
        this.name = name;
        this.startDate = startDate;
        this.type = type;
    }


    public OffsetDateTime getEndDate() {
        return OffsetDateTime.parse(endDate);
    }

    public long getId() {
        return id;
    }

    public boolean isModeSpecific() {
        return modeSpecific;
    }

    public String getName() {
        return name;
    }

    public OffsetDateTime getStartDate() {
        return OffsetDateTime.parse(startDate);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SpotLight{" +
                "endDate='" + endDate + '\'' +
                ", id=" + id +
                ", modeSpecific=" + modeSpecific +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
