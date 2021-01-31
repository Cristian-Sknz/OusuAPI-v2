package me.skiincraft.api.osu.object.ranking;

import me.skiincraft.api.osu.entity.other.Option;
import me.skiincraft.api.osu.entity.ranking.Ranking;
import me.skiincraft.api.osu.object.game.GameMode;

public class RankingOption implements Option<Ranking> {

    private final RankingType type;
    private GameMode gamemode;
    private String country = null;
    private Filter filter = Filter.ALL;
    private int cursor = 1;
    private long spotlight = -1;

    public RankingOption(GameMode gamemode, RankingType type) {
        this.gamemode = gamemode;
        this.type = type;
    }

    public RankingType getType() {
        return type;
    }

    public GameMode getGamemode() {
        return gamemode;
    }

    public RankingOption setGamemode(GameMode gamemode) {
        this.gamemode = gamemode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public RankingOption setCountry(char firstLetter, char secondLetter) {
        validate(firstLetter);
        this.country = String.valueOf(new char[]{firstLetter, secondLetter});
        return this;
    }

    public Filter getFilter() {
        return filter;
    }

    public RankingOption setFilter(Filter filter) {
        this.filter = filter;
        return this;
    }

    public long getSpotlight() {
        return spotlight;
    }

    public RankingOption setSpotlight(long spotlight) {
        validate(spotlight);
        this.spotlight = spotlight;
        return this;
    }

    @Override
    public String toQueueParameter() {
        return String.format("%s/%s%s", gamemode.name().toLowerCase(), type.name().toLowerCase(),
                "?filter=" + filter.name().toLowerCase() + "&cursor=" + cursor + ((type == RankingType.Performance && country != null)
                        ? "&country=" + country
                        : (type == RankingType.Charts && spotlight != -1) ? "&spotlight=" + spotlight : ""));
    }

    @Override
    public Class<Ranking> getOptionType() {
        return Ranking.class;
    }

    public int getCursor() {
        return cursor;
    }

    public RankingOption setCursor(int cursor) {
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
