package ru.rtrn.util;

import java.io.IOException;
import java.util.Properties;

/**
 The PropertiesUtil class loads the set properties in the application.properties configuration file
 */
public final class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream =
                     PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     Method for getting a property by key from a configuration file
     * @param key string key value
     * @return property value as a string
     */
    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
