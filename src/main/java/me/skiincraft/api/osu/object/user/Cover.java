package me.skiincraft.api.osu.object.user;

public class Cover {

    private final String customUrl;
    private final String url;
    private final int id;

    public Cover(String customUrl, String url, int id) {
        this.customUrl = customUrl;
        this.url = url;
        this.id = id;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }
}
