package ru.rtrn;

import ru.rtrn.entity.TravelInfo;
import ru.rtrn.service.TravelService;
import ru.rtrn.util.InputStreamPoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelRunnerTest {
    public static void main(String[] args) {

        TravelService travel = new TravelService();
        travel.generateInitialTravel();
        System.out.println(travel.toIndex());
        TravelService currentSolution = travel;
        System.out.println(currentSolution.toIndex());
        currentSolution.swapPointes();
        System.out.println(currentSolution.toIndex());
    }

    private static void pointsPart1() {
        var pointList = InputStreamPoints.getList();
        pointList.forEach(System.out::println);
        System.out.println("-".repeat(50));
        List<TravelInfo> listTravel = new ArrayList<>();
        for (int i = 0; i < pointList.size(); i++) {
            for (int j = 0; j < pointList.size(); j++) {
                var pointFrom = pointList.get(i);
                var pointTo = pointList.get(j);
                var distance = pointFrom.distanceToPoint(pointTo);
                listTravel.add(new TravelInfo(i, j, distance));
            }
        }
        listTravel.forEach(System.out::println);

        var list = listTravel.stream()
                .filter(d -> d.getDistance() != 0d)
                .sorted(Comparator.comparingDouble(TravelInfo::getDistance))
                .distinct()
                .toList();

        System.out.println("-".repeat(50));

        for (TravelInfo travel :
                list) {
            System.out.printf("\n%d -> %d = %.2f", travel.getPointFrom(), travel.getPointTo(), travel.getDistance());
        }
    }
}
