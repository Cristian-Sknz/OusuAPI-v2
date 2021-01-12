package me.skiincraft.api.osu.object.beatmap;

import java.util.Arrays;

/**
 * <h1>Approval</h1>
 * <p>Are the types of Beatmaps approvals.</p>
 * <p> There are 8 possible approvals, including:
 * <br>
 * UNSPECIFIED(-3)
 * Graveyard(-2)
 * WIP(-1)
 * Pending(0)
 * Ranked(1)
 * Approved(2)
 * Qualified(3)
 * Loved(4)
 * </br>
 */
public enum Approval {

    ANY(-4, false), UNSPECIFIED(-3, false), Graveyard(-2, false), WIP(-1, false), Pending(0, false), Ranked(1, true), Approved(2, true), Qualified(3, true), Loved(4, true);

    private final int id;
    private final boolean scoreable;

    Approval(int id, boolean scoreable) {
        this.id = id;
        this.scoreable = scoreable;
    }

    public static Approval getById(int id) {
        return Arrays.stream(Approval.values()).filter(o -> o.id == id).findFirst().orElse(null);
    }

    public boolean isScoreable() {
        return scoreable;
    }

    public int getId() {
        return this.id;
    }
}
