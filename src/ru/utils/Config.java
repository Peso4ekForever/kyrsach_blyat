package ru.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Config {
    private HashMap<String, String> configData = new HashMap<>();

    public Config LoadConfig(String FilePath) throws IOException {
        FileReader configReader = new FileReader(FilePath);
        Scanner scanner = new Scanner(configReader);

        while (scanner.hasNextLine()) {
            String[] lineData = scanner.nextLine().split("=");
            configData.put(lineData[0], lineData[1]);
        }

        configReader.close();
        return this;
    }

    public String getDataFromConfig(String key) {
        return configData.get(key);
    }
}
