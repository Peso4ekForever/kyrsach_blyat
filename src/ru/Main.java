package ru;

import ru.utils.Config;
import ru.utils.DBConnection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static Config cfg;

    public static void main(String[] args) {
        //Инит
        try {
            cfg = new Config().LoadConfig("./resources/application.cfg");
            cfg.getDataFromConfig("ip");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scanner authorization = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String login = authorization.nextLine();

        System.out.println("Введите пароль: ");
        String password = authorization.nextLine();

        try {
            String url = "jdbc:postgresql://" + cfg.getDataFromConfig("ip") +
                    ":" + cfg.getDataFromConfig("port") + "/" +
                    cfg.getDataFromConfig("database");
            DBConnection connection = new DBConnection(url,
                    login, password).Connect();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
