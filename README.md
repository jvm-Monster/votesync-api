# VoteSync API

Welcome to the VoteSync API project! This REST API is designed to handle database configurations and facilitate seamless integration with voting-related applications.

## Project Overview

The VoteSync API utilizes the ConfigReader class to read database configuration properties from the `votesync-config.properties` file. This README provides essential information on setting up and configuring the API for optimal performance.

## Prerequisites

Before getting started, ensure you have the following prerequisites installed:

- Java (JDK 8 or later)
- [Apache Maven](https://maven.apache.org/)
- A suitable IDE for Java development (e.g., IntelliJ, Eclipse)

## Configuration

### ConfigReader

The `ConfigReader` class is responsible for reading database configuration properties. Here's how to configure it:

1. **Environment Variable Setup (Recommended):**
    - Set the `VOTESYNC_CONFIG_FILE_PATH` environment variable in your cloud environment (e.g., Gitpod) before running the REST API.
    - This environment variable should point to the location of the `votesync-config.properties` file.

   2. **Code Modification:**
       - Modify the `ConfigReader` class to include a conditional check for the `VOTESYNC_CONFIG_FILE_PATH` environment variable.
       - If the variable is not set or is `null`, the class assumes the `votesync-config.properties` file should exist in the home directory of the system.

      ```java
      package com.vi.votesyncapi.util;

       import java.io.FileInputStream;
       import java.io.IOException;
       import java.io.InputStream;
       import java.util.HashMap;
       import java.util.Map;
       import java.util.Properties;
    
       public class ConfigReader {

       String voteSyncDatabaseConfigFileLocation = System.getenv("VOTESYNC_CONFIG_FILE_PATH");
       String configFileName = "/votesync-config.properties";

       public Map<String,String> getDatabasePropertyFile() {
           String getConfigFilePath = System.getProperty("user.home");
           System.out.println(getConfigFilePath);
           if(voteSyncDatabaseConfigFileLocation==null||voteSyncDatabaseConfigFileLocation.isEmpty()){
               voteSyncDatabaseConfigFileLocation=getConfigFilePath.concat(configFileName);
           }
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
        ```
