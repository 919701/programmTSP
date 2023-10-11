package ru.rtrn;

import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;

public class Main {

    public static void main(String[] args) {

        var travelResult = SimulatedAnnealingService.annealing(ReadUtil.getList());

        System.out.println(travelResult.getIndexTravel());
        System.out.println(travelResult.getDistance());
//        WriteUtil.toFile(travelResult);

    }
}
