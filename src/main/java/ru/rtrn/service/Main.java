package ru.rtrn.service;

import ru.rtrn.SimulatedAnnealing.SimulatedAnnealing;

public class Main {
    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();

        var distance = SimulatedAnnealingService.simulateAnnealing(100, 1_000_000, 0.9999);
        System.out.printf("Optimized distance for travel: %.2f\n", distance/1000);

        var endTime = System.currentTimeMillis();
        var timeElapsed = endTime - startTime;
        System.out.println("Time operation: " + timeElapsed);
    }
}
