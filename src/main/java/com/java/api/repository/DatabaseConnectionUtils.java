package com.java.api.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionUtils {

    private static Properties properties;
    static {
        loadDatabaseProperties();
    }


    private static void loadDatabaseProperties()
    {
        String filepath="database.properties";
        try{
            properties = new Properties();
            InputStream is = DatabaseConnectionUtils.class.getClassLoader().getResourceAsStream(filepath);
            properties.load(is);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        if(properties.size() == 0)
            throw new RuntimeException("connection properties are empty");

        String username = properties.getProperty("mysql.database.username");
        String password = properties.getProperty("mysql.database.password");
        String url = properties.getProperty("mysql.database.url");
        String driverClass = com.mysql.jdbc.Driver.class.getName();

        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection)
    {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(DatabaseConnectionUtils.getConnection());
    }
}
