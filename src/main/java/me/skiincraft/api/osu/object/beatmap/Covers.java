package me.skiincraft.api.osu.object.beatmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Covers {

    @Expose
    private final String resourceURL = "https://assets.ppy.sh/beatmaps/%s/covers/%s.jpg";

    private final String cover;
    @SerializedName("cover@2x")
    private final String cover2x;
    private final String card;
    @SerializedName("card@2x")
    private final String card2x;
    private final String list;
    @SerializedName("list@2x")
    private final String list2x;
    private final String slimcover;
    @SerializedName("slimcover@2x")
    private final String slimCover2x;

    @Expose
    private long beatmapSetId;

    public Covers(long beatmapSetId) {
        this.beatmapSetId = beatmapSetId;
        this.cover = format("cover");
        this.cover2x = format("cover@2x");
        this.card = format("card");
        this.card2x = format("card@2x");
        this.list = format("list");
        this.list2x = format("list@2x");
        this.slimcover = format("slimcover");
        this.slimCover2x = format("slimcover@2x");
    }

    private String format(String type){
        return String.format(resourceURL, beatmapSetId, type);
    }

    public String getCover() {
        return cover;
    }

    public String getCover2x() {
        return cover2x;
    }

    public String getCard() {
        return card;
    }

    public String getCard2x() {
        return card2x;
    }

    public String getList() {
        return list;
    }

    public String getList2x() {
        return list2x;
    }

    public String getSlimCover() {
        return slimcover;
    }

    public String getSlimCover2x() {
        return slimCover2x;
    }
}
