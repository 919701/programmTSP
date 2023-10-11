package ru.rtrn.SimulatedAnnealing;

public class TravelRunning {
    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();

        System.out.println(
                "Optimized distance for travel: " + SimulatedAnnealing.simulateAnnealing(100, 1_000_000, 0.9999));

        var endTime = System.currentTimeMillis();
        var timeElapsed = endTime - startTime;
        System.out.println("Time operation: " + timeElapsed);
    }
}
