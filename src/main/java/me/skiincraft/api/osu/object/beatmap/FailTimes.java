package me.skiincraft.api.osu.object.beatmap;

public class FailTimes {

    long[] fail;
    long[] exit;

    public FailTimes(long[] fail, long[] exit) {
        this.fail = fail;
        this.exit = exit;
    }

    public long[] getFail() {
        return fail;
    }

    public long[] getExit() {
        return exit;
    }
}
