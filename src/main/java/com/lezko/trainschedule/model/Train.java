package com.lezko.trainschedule.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Train implements Serializable {
    private final UUID id = UUID.randomUUID();
    private String name;
    private long number;
    private List<TimeTableEntry> schedule = new LinkedList<>();

    public Train(String name, long number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "{ " + this.id + ", " + this.name + ", " + this.number + ", " + this.schedule.size() + " stations }";
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public List<TimeTableEntry> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<TimeTableEntry> schedule) {
        this.schedule = schedule;
    }
}
