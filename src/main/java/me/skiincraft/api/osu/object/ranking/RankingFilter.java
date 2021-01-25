package me.skiincraft.api.osu.object.ranking;

import me.skiincraft.api.osu.object.game.GameMode;

public class RankingFilter {

    private final RankingType type;
    private GameMode gamemode;
    private String country = null;
    private Filter filter = Filter.ALL;
    private int cursor = 1;
    private long spotlight = -1;

    public RankingFilter(GameMode gamemode, RankingType type) {
        this.gamemode = gamemode;
        this.type = type;
    }

    public RankingType getType() {
        return type;
    }

    public GameMode getGamemode() {
        return gamemode;
    }

    public RankingFilter setGamemode(GameMode gamemode) {
        this.gamemode = gamemode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public RankingFilter setCountry(char firstLetter, char secondLetter) {
        validate(firstLetter);
        this.country = String.valueOf(new char[]{firstLetter, secondLetter});
        return this;
    }

    public Filter getFilter() {
        return filter;
    }

    public RankingFilter setFilter(Filter filter) {
        this.filter = filter;
        return this;
    }

    public long getSpotlight() {
        return spotlight;
    }

    public RankingFilter setSpotlight(long spotlight) {
        validate(spotlight);
        this.spotlight = spotlight;
        return this;
    }

    public String toQueueParameter() {
        return String.format("%s/%s%s", gamemode.name().toLowerCase(), type.name().toLowerCase(),
                "?filter=" + filter.name().toLowerCase() + "&cursor=" + cursor + ((type == RankingType.Performance && country != null)
                        ? "&country=" + country
                        : (type == RankingType.Charts && spotlight != -1) ? "&spotlight=" + spotlight : ""));
    }

    public int getCursor() {
        return cursor;
    }

    public RankingFilter setCursor(int cursor) {
        this.cursor = cursor;
        return this;
    }

    public void validate(Object object) {
        if (object instanceof Long) {
            if (type != RankingType.Charts)
                throw new UnsupportedOperationException("Spotlight can be defined only when the type is Charts");
        }
        if (type != RankingType.Performance)
            throw new UnsupportedOperationException("Country can be defined only when the type is Performance");
    }

    public enum Filter {
        ALL, FRIENDS
    }
}
