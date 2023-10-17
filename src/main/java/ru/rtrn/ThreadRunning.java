package ru.rtrn;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;
import ru.rtrn.entity.TravelInfo;
import ru.rtrn.service.SimulatedAnnealingService;
import ru.rtrn.util.ReadUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;

public class ThreadRunning {
    @SneakyThrows
    public static void main(String[] args) {

        CopyOnWriteArrayList<TravelInfo> list = new CopyOnWriteArrayList<>();
        var points = ReadUtil.getList();

        var pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            var future = pool.submit(() -> SimulatedAnnealingService.annealing(points));
            list.add(future.get());
        }
        pool.shutdown();
        list.stream()
                .map(TravelInfo::getIndexTravel)
                .forEach(System.out::println);
    }
}
