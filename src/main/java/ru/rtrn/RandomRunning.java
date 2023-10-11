package ru.rtrn;

import java.util.Random;

public class RandomRunning {
    public static void main(String[] args) {
        var random = new Random();
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {

            var latitude = random.nextDouble(-90, -66);
            var longitude = random.nextDouble(-180, 180);
            String lat = String.valueOf(latitude).replace(",", ".");
            String lon = String.valueOf(longitude).replace(",", ".");
            var s = String.format("%s,%s\n", lat, lon);
            stringBuilder.append(s);
        }

        System.out.println(stringBuilder);
    }
}
