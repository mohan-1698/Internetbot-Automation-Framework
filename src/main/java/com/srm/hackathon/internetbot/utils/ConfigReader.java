package com.srm.hackathon.internetbot.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            String path = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }

        return value.trim(); // ✅ Fix: removes unwanted spaces
    }

    public static int getInt(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}