package ru.rtrn;

import ru.rtrn.util.InputStreamPoints;
import ru.rtrn.util.PropertiesUtil;

public class TravelRunner {
    public static void main(String[] args) {
        var s = PropertiesUtil.get("filename");
        System.out.println(s);

        InputStreamPoints.getList().forEach(System.out::println);
    }
}
