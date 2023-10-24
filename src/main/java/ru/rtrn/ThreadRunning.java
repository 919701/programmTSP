package ru.rtrn;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;
import ru.rtrn.entity.TravelInfo;
import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;
import ru.rtrn.util.WriteUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Comparator.comparing;

public class ThreadRunning {
    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("The optimal route is calculated...\n");
        var startTime = System.currentTimeMillis();
        var points = ReadUtil.getList();

        TravelInfo travelInfo = SimulatedAnnealingService.annealing(points);
        WriteUtil.toFile(travelInfo);

        var endTime = System.currentTimeMillis() - startTime;

        System.out.println("Distance: " + BigDecimal.valueOf(travelInfo.getDistance()).setScale(2, HALF_UP));
        System.out.println("Travel pointer: " + travelInfo.getIndexTravel());
        System.out.println("Times on operation (sec): " + endTime / 1000);
    }
}
