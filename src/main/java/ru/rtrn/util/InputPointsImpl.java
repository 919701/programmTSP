package ru.rtrn.util;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.rtrn.entity.Point;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(staticName = "of")
public class InputPointsImpl {

    @SneakyThrows
    public Map<Integer, Point> getPoints(String fileName) {
        var list = Files.readAllLines(Path.of(fileName));
        var regex = ",";
        var mapPoints = new HashMap<Integer, Point>();
        for (int i = 0; i < list.size(); i++) {
            var points = list.get(i).split(regex);
            var latitude = Double.valueOf(points[0]);
            var longitude = Double.valueOf(points[1]);
            mapPoints.put(i + 1, new Point(latitude, longitude));
        }
        return mapPoints;
    }


}
