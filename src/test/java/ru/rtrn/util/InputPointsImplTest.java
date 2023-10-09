package ru.rtrn.util;

import org.junit.jupiter.api.Test;
import ru.rtrn.entity.CheckPoint;
import ru.rtrn.service.Distance;

import java.util.stream.Stream;

class InputPointsImplTest {

    @Test
    void readPoints() {
        var points = InputPointsImpl.of().getMapPoints("input.txt");
        Stream.of(points).forEach(System.out::println);
    }

    @Test
    void getDistance(){
        var points = InputPointsImpl.of().getMapPoints("input.txt");
        var distance = Distance.getInstance().getDistanceInMeters(points.get(6), points.get(7));
        System.out.printf("distance:" + distance);
    }

    @Test
    void allDistance() {
        var points = InputPointsImpl.of().getMapPoints("input.txt");
        var distance = Distance.getInstance();
        for (CheckPoint dist: points) {

        }
    }
}