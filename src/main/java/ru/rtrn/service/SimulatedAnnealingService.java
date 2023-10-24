package ru.rtrn.service;


import ru.rtrn.entity.Point;
import ru.rtrn.entity.Travel;
import ru.rtrn.util.PropertiesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Comparator.comparing;

/**
 The class implements the annealing method and uses a wider range of solutions at high system temperatures,
 looking for a global optimum. As the temperature decreases, the search range becomes smaller,
 until the global optimum is found.
 */
public class SimulatedAnnealingService {

    private static final String STARTING_TEMPERATURE_KEY = "startingTemperature";
    private static final String NUMBER_OF_ITERATIONS_KEY = "numberOfIterations";
    private static final String COOLING_RATE_KEY = "coolingRate";
    private static final TravelService travel = new TravelService();

    public static Travel simulateAnnealing(ArrayList<Point> points) {
        var random = new Random();
        var startingTemperature = Integer.parseInt(PropertiesUtil.get(STARTING_TEMPERATURE_KEY));
        var coolingRate = Double.parseDouble(PropertiesUtil.get(COOLING_RATE_KEY));

        travel.generateInitialTravel(points);
        double bestDistance = travel.getDistance();
        TravelService currentSolution = travel;

        while (startingTemperature > 0.01) {
            currentSolution.swapPointes();
            double currentDistance = currentSolution.getDistance();
            if (currentDistance < bestDistance) {
                bestDistance = currentDistance;
            } else if (100 * Math.exp((bestDistance - currentDistance) / startingTemperature) < (random.nextDouble(0.95, 1))) {
                currentSolution.revertSwap();
            }
            startingTemperature *= coolingRate;
        }
        return new Travel(currentSolution.getTravel(), currentSolution.toIndex(), bestDistance / 1000);
    }

    /**
     The method uses a wider range of solutions at high system temperatures, seeking a global optimum.
     As the temperature decreases, the search range becomes smaller and smaller until the global optimum is found.
     * @param points list of GPS points
     * @return Travel object in the form of a route
     */
    public static Travel annealing(ArrayList<Point> points) {
        List<Travel> listTravel = new ArrayList<>();

        var numberOfIterations = Integer.parseInt(PropertiesUtil.get(NUMBER_OF_ITERATIONS_KEY));
        for (int i = 0; i < numberOfIterations; i++) {
            var travelResult = SimulatedAnnealingService.simulateAnnealing(points);
            listTravel.add(travelResult);
        }
        return listTravel.stream().min(comparing(Travel::getDistance)).orElseThrow();
    }

    /**
     The method collects statistics among the results obtained and returns the most optimal route
     * @param points  list of GPS points
     * @return Travel object in the form of a route
     */
    public static Travel annealingIf(ArrayList<Point> points) {
        List<Travel> listTravel = new ArrayList<>();
        listTravel.add(SimulatedAnnealingService.simulateAnnealing(points));
        listTravel.add(SimulatedAnnealingService.simulateAnnealing(points));

        while (round(listTravel.get(listTravel.size() - 1).getDistance()) != round(listTravel.get(listTravel.size() - 2).getDistance())) {
            var travelMin = listTravel.get(listTravel.size() - 1).getDistance();
            var travelResult = SimulatedAnnealingService.simulateAnnealing(points);
            var distance = travelResult.getDistance();
            if (distance <= travelMin) {
                listTravel.add(travelResult);
            }
        }
        return listTravel.stream().min(comparing(Travel::getDistance)).orElseThrow();
    }

    private static double round(Double value) {
        double scale = Math.pow(10, 3);
        return Math.ceil(value * scale) / scale;
    }
}