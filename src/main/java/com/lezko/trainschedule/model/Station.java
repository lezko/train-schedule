package com.lezko.trainschedule.model;

import java.util.UUID;

public class Station {
    private final UUID id = UUID.randomUUID();
    private String name;

    public Station(String name) {
        this.name = name;
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
}
