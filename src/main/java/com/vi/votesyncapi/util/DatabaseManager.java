package com.vi.votesyncapi.util;

import com.vi.votesyncapi.exception.DatabaseConnectionException;
import com.vi.votesyncapi.predefinedinterface.TransactionOperation;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DatabaseManager {


    public EntityManager entityManager;
    public EntityManagerFactory entityManagerFactory;
    public EntityTransaction entityTransaction;
    private static String persistentUnitName;


    public DatabaseManager() {
        try {
            Map<String, String> properties =getDBProperty();

            entityManagerFactory = Persistence.createEntityManagerFactory(persistentUnitName,properties);
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
        } catch (RuntimeException r){
            throw r;
        }
        catch (Exception exception) {
            throw new DatabaseConnectionException("Failed to initialize EntityManager");
        }
    }

    private static Map<String, String> getDBProperty() {
        Map<String, String> properties = new HashMap<>();
        ConfigReader configReaderObject = new ConfigReader();
        Map<String,String>configReader = configReaderObject.getDatabasePropertyFile();
        properties.put("javax.persistence.jdbc.url", configReader.get("DB_URL"));
        properties.put("javax.persistence.jdbc.driver",configReader.get("DB_DRIVER"));
        properties.put("javax.persistence.jdbc.user", configReader.get("DB_USER"));
        properties.put("javax.persistence.jdbc.password", configReader.get("DB_PASSWORD"));
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("javax.persistence.persistence-unit.name", configReader.get("DB_PERSISTENT_UNIT"));
        properties.put("jakarta.persistence.transactionType", configReader.get("DB_TRANSACTION_TYPE"));
        properties.put("jakarta.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
        properties.put("hibernate.hbm2ddl.auto","update");
        persistentUnitName=configReader.get("DB_PERSISTENT_UNIT");
        return properties;
    }

    public void executeInTransaction(Runnable operation,String message) {
        try {
            entityTransaction.begin();
            operation.run();
            entityTransaction.commit();
        } catch (Exception e) {
            verifyTransaction(message);
        } finally {
            close();
        }

    }

    public <T> T executeInTransaction(TransactionOperation<T> operation, String message) {
        try {
            entityTransaction.begin();
            T result = operation.execute();
            entityTransaction.commit();
            return result;
        } catch (Exception e) {
            verifyTransaction(message);
        } finally {
            close();
        }
        return null;
    }


    private void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
    private void verifyTransaction(String message) {
        try {
            if (entityTransaction != null && entityTransaction.isActive()) {
                if (entityTransaction.getRollbackOnly()) {
                    entityTransaction.rollback();
                    throw new RuntimeException(message);
                } else {
                    entityTransaction.commit();
                }
            } else{
                throw new PersistenceException(message);
            }
        } catch (Exception e) {
            throw new DatabaseConnectionException("Error while verifying transaction", e);
        }
    }

}

