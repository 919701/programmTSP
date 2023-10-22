package ru.rtrn.creatpoints;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class RandomRunning {
    public static void main(String[] args) {

        var random = new Random();
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {

            var latitude = BigDecimal.valueOf(random.nextDouble(-90, -66)).setScale(6, RoundingMode.HALF_UP);
            var longitude = BigDecimal.valueOf(random.nextDouble(-180, 180)).setScale(6, RoundingMode.HALF_UP);
            String lat = String.valueOf(latitude).replace(",", ".");
            String lon = String.valueOf(longitude).replace(",", ".");
            var s = String.format("%s,%s\n", lat, lon);
            stringBuilder.append(s);
        }

        System.out.println(stringBuilder);
    }
}
