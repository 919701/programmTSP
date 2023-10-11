package ru.rtrn.service;


import ru.rtrn.entity.Point;
import ru.rtrn.entity.TravelInfo;
import ru.rtrn.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SimulatedAnnealingService {

    private static final String STARTING_TEMPERATURE_KEY = "startingTemperature";
    private static final String NUMBER_OF_ITERATIONS_KEY = "numberOfIterations";
    private static final String COOLING_RATE_KEY = "coolingRate";
    private static final String COUNT_OPERATION_KEY = "countOperation";
    private static TravelService travel = new TravelService();

    public static TravelInfo simulateAnnealing(ArrayList<Point> points) {
        var startingTemperature = Integer.parseInt(PropertiesUtil.get(STARTING_TEMPERATURE_KEY));
        var numberOfIterations = Integer.parseInt(PropertiesUtil.get(NUMBER_OF_ITERATIONS_KEY));
        var coolingRate = Double.parseDouble(PropertiesUtil.get(COOLING_RATE_KEY));

        travel.generateInitialTravel(points);
        double bestDistance = travel.getDistance();
        TravelService currentSolution = travel;

        for (int i = 0; i < numberOfIterations; i++) {
            if (startingTemperature > 0.1) {
                currentSolution.swapPointes();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / startingTemperature) < Math.random()) {
                    currentSolution.revertSwap();
                }
                startingTemperature *= coolingRate;
            } else {
                continue;
            }
        }
        return new TravelInfo(currentSolution.getTravel(), currentSolution.toIndex(), bestDistance);
    }
    public static TravelInfo annealing(ArrayList<Point> points) {
        List<TravelInfo> listTravel = new ArrayList<>();
        var countOperation = Integer.parseInt(PropertiesUtil.get(COUNT_OPERATION_KEY));
        for (int i = 0; i < countOperation; i++) {
            var travelResult = SimulatedAnnealingService.simulateAnnealing(points);
            listTravel.add(travelResult);
        }
        return listTravel.stream().min(Comparator.comparing(TravelInfo::getDistance)).get();
    }

}