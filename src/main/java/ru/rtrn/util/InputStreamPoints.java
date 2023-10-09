package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.Point;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class InputStreamPoints {


    private static final String FILE_NAME_KEY = "file.input";
    private static final String SEPARATOR_KEY = "separator";

    private InputStreamPoints() {
    }

    @SneakyThrows
    public static List<Point> getList() {

        var list = Files.readAllLines(Path.of(PropertiesUtil.get(FILE_NAME_KEY)));
        var separator = PropertiesUtil.get(SEPARATOR_KEY);

        List<Point> points = new ArrayList<>();
        for (String s : list) {
            var split = s.split(separator);
            var latitude = Double.parseDouble(split[0]);
            var longitude = Double.parseDouble(split[1]);
            points.add(new Point(latitude, longitude));
        }
        return points;
    }
}
