package me.skiincraft.api.osu.object.beatmap;

import me.skiincraft.api.osu.entity.other.Option;
import me.skiincraft.api.osu.object.game.GameMode;

public class SearchOption implements Option {

    private GameMode gameMode = GameMode.Osu;
    private Approval category = Approval.ANY;
    private Genre genre = Genre.Any;
    private Language language = Language.Any;

    private boolean video = false;
    private boolean storyboard = false;

    private SearchSort sort = SearchSort.RANKED;
    private int sortType = SearchSort.DECREMENT;

    public SearchOption setVideo(boolean video) {
        this.video = video;
        return this;
    }

    public SearchOption setStoryboard(boolean storyboard) {
        this.storyboard = storyboard;
        return this;
    }

    public SearchOption setSort(SearchSort sort, int sortType) {
        this.sort = sort;
        this.sortType = sortType;
        return this;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public SearchOption setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public Approval getCategory() {
        return category;
    }

    public SearchOption setCategory(Approval category) {
        this.category = category;
        return this;
    }

    public Genre getGenre() {
        return genre;
    }

    public SearchOption setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public SearchOption setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public boolean videoIsFiltered() {
        return video;
    }

    public boolean storyboardIsFiltered() {
        return storyboard;
    }

    public SearchSort getSort() {
        return sort;
    }

    public int getSortType() {
        return sortType;
    }

    @Override
    public String toQueueParameter() {
        return "m=" + gameMode.getId() +
                (isAny(category) ? "" : "&s=" + category.name().toLowerCase()) +
                (isAny(genre) ? "" : "&g=" + genre.getId()) +
                (isAny(language) ? "" : "&l=" + language.getId()) +
                ((video && storyboard) ? "&e=video.storyboard" : (video) ? "&e=video" : (storyboard) ? "&e=storyboard" : "") +
                ((sort == SearchSort.RANKED && sortType >= SearchSort.DECREMENT) ? "" : "&sort=" + sort.getParameter(sortType));
    }

    private <E extends Enum<E>> boolean isAny(Enum<E> enums) {
        return enums.name().equalsIgnoreCase("any");
    }

    @Override
    public String toString() {
        return "SearchOption{" +
                "gameMode=" + gameMode +
                ", category=" + category +
                ", genre=" + genre +
                ", language=" + language +
                ", video=" + video +
                ", storyboard=" + storyboard +
                ", sort=" + sort.getParameter(sortType) +
                '}';
    }

    public enum SearchSort {

        TITLE, ARTIST, DIFFICULT, RANKED, RATING, PLAYS, FAVOURITES;

        public static final int CRESCENT = 0;
        public static final int DECREMENT = 1;

        public String getParameter(int sortType) {
            return name().toLowerCase() + "_" + ((sortType == 0) ? "asc" : "desc");
        }
    }

}
