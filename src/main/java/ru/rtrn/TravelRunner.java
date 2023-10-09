package ru.rtrn;

import ru.rtrn.entity.Point;
import ru.rtrn.util.InputStreamPoints;
import ru.rtrn.util.PropertiesUtil;

import java.util.List;

public class TravelRunner {
    public static void main(String[] args) {

        var pointList = InputStreamPoints.getList();
        pointList.forEach(System.out::println);

        System.out.println("-".repeat(50));

        var point5 = pointList.get(5);
        System.out.println(point5);
        var pointTo = pointList.get(6);
        System.out.println(pointTo);

        var distance = point5.distanceToPoint(pointTo);
        System.out.printf("Distance: %.2f", distance/1000);
    }
}
