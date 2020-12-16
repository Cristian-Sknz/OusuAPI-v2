package me.skiincraft.api.osu.util;

import java.lang.reflect.Field;

public class ReflectionUtil {

    public static <T> void setField(T item, String fieldName, Object to) {
        try {
            Field field = item.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(item, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
