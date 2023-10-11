package ru.rtrn.service;


import ru.rtrn.entity.TravelInfo;

public class SimulatedAnnealingService {

    private static TravelService travel = new TravelService();

    public static TravelInfo simulateAnnealing(double startingTemperature, int numberOfIterations, double coolingRate) {
        double t = startingTemperature;
        travel.generateInitialTravel();
        double bestDistance = travel.getDistance();
        TravelService currentSolution = travel;

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
        }
        return new TravelInfo(currentSolution.getTravel(), currentSolution.toIndex(), bestDistance);
    }

}