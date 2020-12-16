package me.skiincraft.api.osu.entity.score;

import me.skiincraft.api.osu.impl.score.ScoreImpl;

public class UserScore {

    private final long position;
    private final ScoreImpl score;

    public UserScore(long position, ScoreImpl score) {
        this.position = position;
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public long getPosition() {
        return position;
    }
}
