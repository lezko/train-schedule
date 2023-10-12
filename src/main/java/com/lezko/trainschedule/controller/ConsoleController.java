package com.lezko.trainschedule.controller;

import com.lezko.trainschedule.model.Train;
import com.lezko.trainschedule.repository.InMemoryTrainRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleController {

    private static final InMemoryTrainRepository repository = InMemoryTrainRepository.getInstance();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Listening for commands...");
        while (!Objects.equals(input = scanner.nextLine(), "exit")) {
            String[] arr = input.split("\\s");
            String command = arr[0];
            switch (command) {
                case "print" -> {
                    if (arr.length == 1) {
                        printAllTrains();
                    } else {
                        List<UUID> ids = new LinkedList<>();
                        for (int i = 1; i < arr.length; i++) {
                            ids.add(UUID.fromString(arr[i]));
                        }
                        printTrainsByIds(ids);
                    }
                }
                case "delete" -> {
                    for (int i = 1; i < arr.length; i++) {
                        repository.deleteById(UUID.fromString(arr[i]));
                    }
                }
            }
        }
        System.out.println("Program shut down");
    }

    private static void printAllTrains() {
        System.out.println(repository.findAll().stream().map(Train::toString).collect(Collectors.joining("\n")));
    }

    private static void printTrainsByIds(Collection<UUID> ids) {
        List<Train> toPrint = repository.findAll().stream().filter(t -> ids.contains(t.getId())).toList();
        System.out.println(toPrint.stream().map(Train::toString).collect(Collectors.joining("\n")));
    }
}
