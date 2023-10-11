package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ReadUtil {


    private static final String FILE_NAME_KEY = "file.input";
    private static final String SEPARATOR_KEY = "separator";

    private ReadUtil() {
    }

    @SneakyThrows
    public static ArrayList<Point> getList() {

        var path = Path.of(PropertiesUtil.get(FILE_NAME_KEY));
        var list = Files.readAllLines(path);
        var separator = PropertiesUtil.get(SEPARATOR_KEY);

        ArrayList<Point> points = new ArrayList<>();
        for (String s : list) {
            var split = s.split(separator);
            var latitude = Double.parseDouble(split[0]);
            var longitude = Double.parseDouble(split[1]);
            points.add(new Point(latitude, longitude));
        }
        return points;
    }

    public static Map<Integer,Point> getMap() {
        Map<Integer,Point> points = new HashMap<>();
        int i=0;
        for (Point point :
                getList()) {
            points.put(++i, point);
        }
        return points;
    }
}
