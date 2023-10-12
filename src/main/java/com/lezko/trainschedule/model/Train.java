package com.lezko.trainschedule.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Train {
    private final UUID id = UUID.randomUUID();
    private String name;
    private long number;
    private List<Schedule> schedules = new LinkedList<>();

    public Train(String name, long number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.number + "\n" + schedules.stream().map(Schedule::toString).collect(Collectors.joining("\n")) + "\n";
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
