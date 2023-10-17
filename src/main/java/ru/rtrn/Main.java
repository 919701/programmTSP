package ru.rtrn;

import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;
import ru.rtrn.util.WriteUtil;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting...\n");
        var travelResult = SimulatedAnnealingService.annealing(ReadUtil.getList());

        System.out.println("Result:");
        System.out.println(travelResult.getIndexTravel());
        System.out.println(BigDecimal.valueOf(travelResult.getDistance()).setScale(2, HALF_UP));
        WriteUtil.toFile(travelResult);

    }
}
