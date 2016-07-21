package com.karayvansky.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileOut {
    private Map<String, Integer> result;
    private String directory;

    public FileOut(Map<String, Integer> result, String directory) {
        this.result = result;
        this.directory = directory;
    }

    public void insertMapToFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(fileWriter);) {
            for (String word : result.keySet()) {
                writer.write(word + " : " + result.get(word));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
