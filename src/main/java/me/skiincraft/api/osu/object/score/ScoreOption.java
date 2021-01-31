package me.skiincraft.api.osu.object.score;

import me.skiincraft.api.osu.entity.other.Option;
import me.skiincraft.api.osu.object.game.GameMode;

public class ScoreOption implements Option {

    private ScoreType type;
    private GameMode gameMode;
    private int limit;
    private int offset;
    private boolean includeFails;

    public ScoreOption() {
        this.type = ScoreType.BEST;
        this.limit = 10;
    }

    public ScoreOption(GameMode gameMode) {
        this.type = ScoreType.BEST;
        this.gameMode = gameMode;
        this.limit = 10;
    }

    public ScoreOption(ScoreType type) {
        this.type = type;
        this.limit = 10;
    }

    public ScoreType getType() {
        return type;
    }

    public ScoreOption setType(ScoreType type) {
        this.type = type;
        return this;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public ScoreOption setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public ScoreOption setLimit(int limit) {
        this.limit = Math.max(limit, 10);
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public ScoreOption setIncludeFails(boolean includeFails) {
        this.includeFails = includeFails;
        return this;
    }

    public boolean isIncludeFails() {
        return includeFails;
    }

    public int getIncludeFails(){
        return (includeFails) ? 1 : 0;
    }

    public ScoreOption setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public String toQueueParameter() {
        return "limit=" + limit + ((type == ScoreType.RECENT && includeFails) ? "&include_fails=" + getIncludeFails() : "") +
                ((gameMode != null) ? "&mode=" + gameMode.name().toLowerCase() : "") +
                ((offset != 0) ? "&offset=" + offset : "");
    }

    public String toV1QueueParameter() {
        return "limit=" + limit + ((gameMode != null) ? "&mode=" + gameMode.getId() : "");
    }
}
