package ru.rtrn.util;

import org.junit.jupiter.api.Test;
import ru.rtrn.entity.Point;
import ru.rtrn.service.Distance;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.stream.Stream;

class InputPointsImplTest {

    @Test
    void readPoints() {
        var points = InputPointsImpl.of().getPoints("input.txt");
        Stream.of(points).forEach(System.out::println);
    }

    @Test
    void getDistance(){
        var points = InputPointsImpl.of().getPoints("input.txt");
        var distanceInMeters = Distance.getInstance().getDistanceInMeters(points.get(6), points.get(7));

        System.out.println(distanceInMeters);
    }
}