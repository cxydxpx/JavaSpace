package com.example.javademo.binary;

public class TimeUtils {

    private static long lastTime;

    public static boolean isFastDoubleClick(long time) {
        long var0 = System.currentTimeMillis();
        if (var0 - lastTime < time) {
            lastTime = var0;
            return true;
        } else {
            lastTime = var0;
            return false;
        }
    }

}
