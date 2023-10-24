package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 A class designed to record application execution results to an output file
 */
public final class ReadUtil {

    private static final String FILE_NAME_KEY = "file.input";
    private static final String SEPARATOR_KEY = "separator";

    private ReadUtil() {
    }

    /**
     The method reads data from the file line by line and returns a list of points as an array
     * @return array of GPS points objects
     */
    @SneakyThrows
    public static ArrayList<Point> getList() {

        var pathLocal = Path.of(ReadUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().toString();
        var path = Path.of(pathLocal, PropertiesUtil.get(FILE_NAME_KEY));
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

    /**
     The method numbers points according to their location in the input file
     * @return map with the serial number of the GPS point and the GPS point itself
     */
    public static Map<Integer,Point> getMap() {
        Map<Integer, Point> points = new HashMap<>();
        for (int i = 0; i < getList().size() - 1; i++) {
            points.put(i + 1, getList().get(i));
        }
        return points;
    }
}
