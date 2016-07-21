package com.karayvansky.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileOut {
    private Map<String, Integer> result;

    public FileOut(Map<String, Integer> result) {
        this.result = result;
    }

    public void insertMapToFile(FileWriter file) {
        try (BufferedWriter writer = new BufferedWriter(file)) {
            for (String word : result.keySet()) {
                writer.write(word + " : " + result.get(word));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
