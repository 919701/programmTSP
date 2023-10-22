package ru.rtrn.service;


import ru.rtrn.entity.Point;
import ru.rtrn.entity.TravelInfo;
import ru.rtrn.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class SimulatedAnnealingService {

    private static final String STARTING_TEMPERATURE_KEY = "startingTemperature";
    private static final String NUMBER_OF_ITERATIONS_KEY = "numberOfIterations";
    private static final String COOLING_RATE_KEY = "coolingRate";
    private static final TravelService travel = new TravelService();

    public static TravelInfo simulateAnnealing(ArrayList<Point> points) {
        var startingTemperature = Integer.parseInt(PropertiesUtil.get(STARTING_TEMPERATURE_KEY));

        var coolingRate = Double.parseDouble(PropertiesUtil.get(COOLING_RATE_KEY));

        travel.generateInitialTravel(points);
        double bestDistance = travel.getDistance();
        TravelService currentSolution = travel;
        for (int i = 0; i < 5; i++) {
            while (startingTemperature > 0.01) {
                currentSolution.swapPointes();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (100 * Math.exp((bestDistance - currentDistance) / startingTemperature) < Math.random()) {
                    currentSolution.revertSwap();
                }
                startingTemperature *= coolingRate;
            }
            startingTemperature *= 100000;
        }
        return new TravelInfo(currentSolution.getTravel(), currentSolution.toIndex(), bestDistance / 1000);
    }


    public static TravelInfo annealing(ArrayList<Point> points) {
        List<TravelInfo> listTravel = new ArrayList<>();
        var pointsNew = new ArrayList<>(points);
        var numberOfIterations = Integer.parseInt(PropertiesUtil.get(NUMBER_OF_ITERATIONS_KEY));
        for (int i = 0; i < numberOfIterations; i++) {
            var travelResult = SimulatedAnnealingService.simulateAnnealing(pointsNew);
            listTravel.add(travelResult);
        }
        return listTravel.stream().min(comparing(TravelInfo::getDistance)).get();
    }
}