package ru.rtrn.service;

import ru.rtrn.util.MapperToIndexPoint;

public class SimulatedAnnealingService {

    private static TravelService travel = new TravelService();

    public static double simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRate) {
        System.out.println("Starting SA with temperature: " + startingTemperature + ", # of iterations: " + numberOfIterations + " and colling rate: " + coolingRate);
        double t = startingTemperature;
        travel.generateInitialTravel();
        System.out.println("\n*******************  travel  *******************\n" + travel.toIndex());

        double bestDistance = travel.getDistance();
        System.out.println("\n*******************  bestDistance  *******************\n" + bestDistance / 1000);

        TravelService currentSolution = travel;
        System.out.println("*******************currentSolution  *******************\n" + currentSolution.toIndex());

        for (int i = 0; i < numberOfIterations; i++) {
            if (t > 0.1) {
                currentSolution.swapPointes();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
                    currentSolution.revertSwap();
                }
                t *= coolingRate;
            } else {
                continue;
            }
//            if (i % 100 == 0) {
//                System.out.println("Iteration #" + i);
//            }
        }
        System.out.println("-".repeat(50));
        System.out.println("\n*******************  currentSolution  *******************\n" + currentSolution.toIndex());
        System.out.println("-".repeat(50));

        return bestDistance;
    }

}