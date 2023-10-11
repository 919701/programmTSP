package ru.rtrn.service;

import lombok.Data;
import ru.rtrn.entity.Point;
import ru.rtrn.util.ReadUtil;

import java.util.ArrayList;
import java.util.Map;

@Data
public class TravelService {

    private ArrayList<Point> travel;
    private ArrayList<Point> previousTravel = new ArrayList<>();

    public void generateInitialTravel() {
        var points = ReadUtil.getList();
        var pointFist = points.get(0);
        points.add(pointFist);
        travel = points;
    }

    public void swapPointes() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        previousTravel = new ArrayList<>(travel);
        Point x = travel.get(a);
        Point y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    public void revertSwap() {
        travel = previousTravel;
    }

    private int generateRandomIndex() {
        var max = travel.size() - 3;
        var min = 1;
        return (int) (Math.random() * ++max) + min;
    }

    private Point getPoint(int index) {
        return travel.get(index);
    }

    public double getDistance() {
        double distance = 0;
        for (int index = 0; index < travel.size(); index++) {
            Point starting = getPoint(index);
            Point destination;
            if (index + 1 < travel.size()) {
                destination = getPoint(index + 1);
            } else {
                destination = getPoint(0);
            }
            distance += starting.distanceToPoint(destination);
        }
        return distance;
    }

    public ArrayList<Integer> toIndex() {
        var pointList = travel;
        var indexList = new ArrayList<Integer>();
        var pointMap = ReadUtil.getMap();
        for (Point point :
                pointList) {
            var index = pointMap.entrySet().stream()
                    .filter(p -> point.equals(p.getValue()))
                    .map(Map.Entry::getKey)
                    .findFirst().get();
            indexList.add(index);
        }
        return indexList;
    }
}