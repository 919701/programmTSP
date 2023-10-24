package ru.rtrn;

import lombok.SneakyThrows;
import ru.rtrn.entity.Travel;
import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;
import ru.rtrn.util.WriteUtil;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class TspRunning {
    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("The optimal route is calculated...\n");
        var startTime = System.currentTimeMillis();
        var points = ReadUtil.getList();
        Travel travel = (points.size()+1 <= 25)
                ? SimulatedAnnealingService.annealingIf(points)
                : SimulatedAnnealingService.annealing(points);

        WriteUtil.toFile(travel);

        var endTime = System.currentTimeMillis() - startTime;

        System.out.println("Distance: " + BigDecimal.valueOf(travel.getDistance()).setScale(2, HALF_UP));
        System.out.println("Travel pointer: " + travel.getIndexTravel());
        System.out.println("Times on operation (sec): " + endTime / 1000);
    }
}
