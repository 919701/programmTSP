package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

        Set<Point> points = new LinkedHashSet<>();
        for (String s : list) {
            var split = s.split(separator);
            var latitude = Double.parseDouble(split[0]);
            var longitude = Double.parseDouble(split[1]);
            points.add(new Point(latitude, longitude));
        }
        var objects = new ArrayList<Point>(points);
        objects.add(objects.get(0));
        return objects;
    }

    public static Map<Integer,Point> getMap() {
        Map<Integer, Point> points = new HashMap<>();
        for (int i = 0; i < getList().size() - 1; i++) {
            points.put(i + 1, getList().get(i));
        }
        return points;
    }
}
