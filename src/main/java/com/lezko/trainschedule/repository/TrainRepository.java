package com.lezko.trainschedule.repository;

import com.lezko.trainschedule.model.Train;

import java.util.List;
import java.util.UUID;

public interface TrainRepository {
    List<Train> findAll();

    void add(Train train);

    Train findById(UUID id);

    void deleteById(UUID id);

    void updateById(UUID id, Train newTrain);
}
