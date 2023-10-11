package ru.rtrn.service;

import ru.rtrn.util.WriteUtil;

public class Main {
    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();

        var travelResult = SimulatedAnnealingService.simulateAnnealing(100, 1_000_000, 0.9999);

        System.out.println(travelResult.getIndexTravel());
        System.out.println(travelResult.getDistance());

        var endTime = System.currentTimeMillis();
        var timeElapsed = endTime - startTime;
        System.out.println("Time operation: " + timeElapsed);

        WriteUtil.toFile(travelResult);
    }
}
