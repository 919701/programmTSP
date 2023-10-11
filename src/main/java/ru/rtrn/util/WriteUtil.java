package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.TravelInfo;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class WriteUtil {

    private static final String FILE_NAME_KEY = "file.output";
    private static final String AUTHOR = "Sergeev Sergey Nikolaevich";

    private WriteUtil() {
    }

    @SneakyThrows
    public static void toFile(TravelInfo travelInfo) {
        var path = Path.of(PropertiesUtil.get(FILE_NAME_KEY));
        var result = String.format("%s\n%s\n%s",
                AUTHOR,
                travelInfo.getDistance(),
                travelInfo.getIndexTravel());
        Files.writeString(path,
               result,
               StandardCharsets.UTF_8);
    }
}
