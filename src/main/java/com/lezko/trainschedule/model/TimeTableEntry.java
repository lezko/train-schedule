package com.lezko.trainschedule.model;

import com.lezko.trainschedule.utils.Time;

import java.util.UUID;

public class TimeTableEntry {
    private final UUID id = UUID.randomUUID();
    private Station station;
    private int arrivalTime;
    private int departureTime;

    public TimeTableEntry(Station station, int arrivalTime, int departureTime) {
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return String.format("{ %s, arrival: %s, departure: %s }", station, Time.fromInt(arrivalTime), Time.fromInt(departureTime));
    }

    public UUID getId() {
        return id;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }
}
