package com.vi.votesyncapi.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
    String voteSyncDatabaseConfigFileLocation = System.getenv("VOTESYNC_CONFIG_FILE_PATH");

    public Map<String,String> getDatabasePropertyFile() {
        System.out.println(voteSyncDatabaseConfigFileLocation);
        Properties properties = new Properties();
        Map<String,String> propertyValues = null;
        try (InputStream input = new FileInputStream(voteSyncDatabaseConfigFileLocation)) {
            properties.load(input);

            // Access properties
            String dbUrl = properties.getProperty("DB_URL");
            String dbDriver = properties.getProperty("DB_DRIVER");
            String dbUser = properties.getProperty("DB_USER");
            String dbPassword = properties.getProperty("DB_PASSWORD");
            propertyValues=new HashMap<>();
            propertyValues.put("DB_URL",dbUrl);
            propertyValues.put("DB_DRIVER",dbDriver);
            propertyValues.put("DB_USER",dbUser);
            propertyValues.put("DB_PASSWORD",dbPassword);
            return propertyValues;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return propertyValues;
    }
}