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

    ANY(-4), UNSPECIFIED(-3), Graveyard(-2), WIP(-1), Pending(0), Ranked(1), Approved(2), Qualified(3), Loved(4);

    private final int id;

    Approval(int id) {
        this.id = id;
    }

    public static Approval getById(int id) {
        return Arrays.stream(Approval.values()).filter(o -> o.id == id).findFirst().orElse(null);
    }

    public int getId() {
        return this.id;
    }
}
