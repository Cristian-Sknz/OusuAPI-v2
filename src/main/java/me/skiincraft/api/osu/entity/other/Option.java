package me.skiincraft.api.osu.entity.other;

public interface Option<T> {

    default String toQueueParameter() {
        return null;
    }
    Class<T> getOptionType();
}
