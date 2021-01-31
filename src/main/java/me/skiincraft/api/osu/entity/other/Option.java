package me.skiincraft.api.osu.entity.other;

public interface Option {

    default String toQueueParameter() {
        return null;
    }
}
