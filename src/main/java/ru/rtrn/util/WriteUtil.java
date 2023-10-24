package ru.rtrn.util;

import lombok.SneakyThrows;
import ru.rtrn.entity.TravelInfo;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.math.RoundingMode.HALF_UP;

/**
 Class for writing results to an output file
 */
public final class WriteUtil {

    private static final String FILE_NAME_KEY = "file.output";
    private static final String AUTHOR = "Sergeev Sergey Nikolaevich";

    private WriteUtil() {
    }

    /**
     The method allows you to write the result to an output file,
     where the file name is pulled from the application properties
     * @param travelInfo
     */
    @SneakyThrows
    public static void toFile(TravelInfo travelInfo) {
        var pathLocal = Path.of(WriteUtil.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent().toString();
        var path =Path.of(pathLocal,PropertiesUtil.get(FILE_NAME_KEY));
        var result = String.format("%s\n%s\n%s",
                AUTHOR,
                BigDecimal.valueOf(travelInfo.getDistance()).setScale(2, HALF_UP),
                travelInfo.getIndexTravel());
        Files.writeString(path, result, StandardCharsets.UTF_8);
    }
}
