package ru.rtrn.SimulatedAnnealing;

public class TravelRunning {
    public static void main(String[] args) {
        System.out.println(
                "Optimized distance for travel: " + SimulatedAnnealing.simulateAnnealing(8, 10000, 0.9995));
    }
}
