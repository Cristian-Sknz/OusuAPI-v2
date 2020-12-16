package me.skiincraft.api.osu.object.beatmap;

import com.google.gson.annotations.SerializedName;

public class Covers {

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

    public Covers(String cover, String cover2x, String card, String card2x, String list, String list2x, String slimcover, String slimcover2x) {
        this.cover = cover;
        this.cover2x = cover2x;
        this.card = card;
        this.card2x = card2x;
        this.list = list;
        this.list2x = list2x;
        this.slimcover = slimcover;
        this.slimCover2x = slimcover2x;
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
