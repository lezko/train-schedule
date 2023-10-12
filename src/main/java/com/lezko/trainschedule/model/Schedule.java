package com.lezko.trainschedule.model;

import com.lezko.trainschedule.utils.Time;

import java.util.*;
import java.util.stream.Collectors;

public class Schedule {
    private final UUID id = UUID.randomUUID();
    private List<TimeTableEntry> stations = new LinkedList<>();

    public static class WeekdayTimePair {
        Weekday weekday;
        int time;

        public WeekdayTimePair(Weekday weekday, int time) {
            this.weekday = weekday;
            this.time = time;
        }

        public Weekday getWeekday() {
            return weekday;
        }

        public void setWeekday(Weekday weekday) {
            this.weekday = weekday;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    private List<WeekdayTimePair> startTimes = new LinkedList<>();

    public Schedule(List<TimeTableEntry> stations, List<WeekdayTimePair> startTimes) {
        this.stations = stations;
        this.startTimes = startTimes;
    }

    public UUID getId() {
        return id;
    }

    public List<TimeTableEntry> getStations() {
        return stations;
    }

    public void setStations(List<TimeTableEntry> stations) {
        this.stations = stations;
    }

    public List<WeekdayTimePair> getStartTimes() {
        return startTimes;
    }

    public void setStartTimes(List<WeekdayTimePair> startTimes) {
        this.startTimes = startTimes;
    }

    @Override
    public String toString() {
        StringBuilder startTimesStr = new StringBuilder();
        for (WeekdayTimePair p : startTimes) {
            startTimesStr.append(p.weekday).append(", ").append(Time.fromInt(p.time)).append("\n");
        }

        return startTimesStr + stations.stream().map(TimeTableEntry::toString).collect(Collectors.joining(", ", "[ ", " ]"));
    }
}
