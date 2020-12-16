package me.skiincraft.api.osu.object.user;

import java.time.LocalDate;

public class Count {

    private final LocalDate startDate;
    private final long count;

    public Count(LocalDate startDate, long count) {
        this.startDate = startDate;
        this.count = count;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public long getCount() {
        return count;
    }
}
