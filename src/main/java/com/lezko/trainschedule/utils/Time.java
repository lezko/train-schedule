package com.lezko.trainschedule.utils;

public class Time {
    public static String fromInt(int t) {
        return String.format("%d:%d", t / 60, t % 60);
    }
}
