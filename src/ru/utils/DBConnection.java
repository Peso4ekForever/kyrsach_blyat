package ru.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String url;
    private static String login;
    private static String password;

    public DBConnection(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public DBConnection Connect() throws SQLException {
        Connection connection = DriverManager.getConnection(url, login, password);
        System.out.println("Успешное соеденение!");

        connection.close();
        return this;
    }
}
