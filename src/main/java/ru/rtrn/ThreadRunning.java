package ru.rtrn;

import lombok.SneakyThrows;
import ru.rtrn.entity.TravelInfo;
import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;
import ru.rtrn.util.WriteUtil;

import java.math.BigDecimal;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Comparator.comparing;

public class ThreadRunning {
    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("The optimal route is calculated...\n");
        var s = System.currentTimeMillis();

        CopyOnWriteArrayList<TravelInfo> list = new CopyOnWriteArrayList<>();
        var points = ReadUtil.getList();
        var pool = Executors.newWorkStealingPool(5);
        for (int i = 0; i < 5; i++) {
            var future = pool.submit(() -> SimulatedAnnealingService.annealing(points));
            list.add(future.get());
        }
        pool.shutdown();
        var travelInfo = list.stream().min(comparing(TravelInfo::getDistance)).get();
        var end = System.currentTimeMillis() - s;

        System.out.println("Distance: " + BigDecimal.valueOf(travelInfo.getDistance()).setScale(2, HALF_UP));
        System.out.println("Travel pointer: " + travelInfo.getIndexTravel());


        System.out.println("Times on operation: " + end / 1000);
        WriteUtil.toFile(travelInfo);
    }
}
