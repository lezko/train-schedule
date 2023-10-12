package com.lezko.trainschedule.repository;

import com.lezko.trainschedule.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryTrainRepository implements TrainRepository {

    private List<Train> trains;

    private static InMemoryTrainRepository INSTANCE;
    private InMemoryTrainRepository() {
        trains = List.of(
                new Train("Pivozavr", 55),
                new Train("Chipsoed", 309),
                new Train("Mutant", 333)
        );
        Schedule s = new Schedule(List.of(
                new TimeTableEntry(new Station("Osinavaya"), 0, 0),
                new TimeTableEntry(new Station("Kosmonavtov"), 60, 65),
                new TimeTableEntry(new Station("Berezovaya"), 100, 120),
                new TimeTableEntry(new Station("Slivovaya"), 180, 180)
        ), List.of(
                new Schedule.WeekdayTimePair(Weekday.MONDAY, 20),
                new Schedule.WeekdayTimePair(Weekday.MONDAY, 180),
                new Schedule.WeekdayTimePair(Weekday.FRIDAY, 333)
        ));
        trains.get(0).getSchedules().add(s);
    };

    public static InMemoryTrainRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryTrainRepository();
        }
        return INSTANCE;
    }

    @Override
    public List<Train> findAll() {
        return trains;
    }

    @Override
    public Train findById(UUID id) {
        return trains.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        trains = trains.stream().filter(t -> !t.getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public void updateById(UUID id, Train newTrain) {
        Train train = trains.stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(() ->
                new RuntimeException("Train with id " + id.toString() + " not found.")
        );
        int idx = trains.indexOf(train);
        trains.set(idx, newTrain);
    }

    @Override
    public void add(Train train) {
        trains.add(train);
    }
}
