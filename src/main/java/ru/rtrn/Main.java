package ru.rtrn;

import ru.rtrn.entity.TravelInfo;
import ru.rtrn.service.SimulatedAnnealingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var startTime = System.currentTimeMillis();

        var startingTemperature = 100;
        var numberOfIterations = 1_000_000;
        var coolingRate = 0.995;

        List<TravelInfo> listTravel = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            var travelResult = SimulatedAnnealingService.simulateAnnealing(startingTemperature, numberOfIterations, coolingRate);
//            System.out.println(travelResult.getIndexTravel() + " " + travelResult.getDistance());
            listTravel.add(travelResult);
        }

        var travelInfo = listTravel.stream().min(Comparator.comparing(TravelInfo::getDistance)).get();
        System.out.println(travelInfo.getDistance());
        System.out.println(travelInfo.getIndexTravel());
//        WriteUtil.toFile(travelResult);


        var endTime = System.currentTimeMillis();
        var timeElapsed = endTime - startTime;
        System.out.println("Time operation: " + timeElapsed);
    }
}
