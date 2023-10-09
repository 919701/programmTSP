package ru.rtrn.util;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.rtrn.entity.CheckPoint;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@NoArgsConstructor(staticName = "of")
public class InputPointsImpl {

    @SneakyThrows
    public Map<Integer, CheckPoint> getMapPoints(String fileName) {
        var list = Files.readAllLines(Path.of(fileName));
        var regex = ",";
        var mapPoints = new HashMap<Integer, CheckPoint>();
        for (int i = 0; i < list.size(); i++) {
            var points = list.get(i).split(regex);
            var latitude = Double.valueOf(points[0]);
            var longitude = Double.valueOf(points[1]);
            mapPoints.put(i + 1, new CheckPoint(latitude, longitude));
        }
        return mapPoints;
    }

    @SneakyThrows
    public List<CheckPoint> getListPoints(String fileName) {
        var list = Files.readAllLines(Path.of(fileName));
        var regex = ",";

        List<CheckPoint> checkPointList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            var points = list.get(i).split(regex);
            var latitude = Double.valueOf(points[0]);
            var longitude = Double.valueOf(points[1]);
            checkPointList.add(new CheckPoint(latitude, longitude));
        }
        return checkPointList;
    }

}
