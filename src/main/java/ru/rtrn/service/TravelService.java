package ru.rtrn.service;

import lombok.Data;
import ru.rtrn.entity.Point;
import ru.rtrn.util.ReadUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Data
public class TravelService {

    private ArrayList<Point> travel;
    private ArrayList<Point> previousTravel = new ArrayList<>();

    public void generateInitialTravel(ArrayList<Point> points) {
        travel = points;
    }

    public void swapPointes() {
        var random = new Random();
        int a = random.nextInt(1, travel.size()-1);
        int b = random.nextInt(1, travel.size()-1);
        previousTravel = new ArrayList<>(travel);
        Point x = travel.get(a);
        Point y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    public void revertSwap() {
        travel = previousTravel;
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