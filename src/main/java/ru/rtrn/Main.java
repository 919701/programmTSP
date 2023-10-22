package ru.rtrn;

import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;
import ru.rtrn.util.WriteUtil;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Main {

    public static void main(String[] args) {
        var s = System.currentTimeMillis();

        System.out.println("The optimal route is calculated...\n");
        var travelResult = SimulatedAnnealingService.annealing(ReadUtil.getList());

        System.out.println("Result:");
        System.out.println(travelResult.getIndexTravel());
        System.out.println(BigDecimal.valueOf(travelResult.getDistance()).setScale(2, HALF_UP));

        var end = System.currentTimeMillis() - s;
        System.out.println("Time: " + end / 1000);

        WriteUtil.toFile(travelResult);
    }
}
