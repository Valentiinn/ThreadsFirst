package com.karayvansky.threads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HashMapThird extends Thread {
    private Map<String, Integer> result;

    public HashMapThird(Map<String, Integer> result) {
        this.result = result;
    }

    @Override
    public void run() {
        FileReader fileReader = null;
        String line = null;
        try {
            fileReader = new FileReader("d:\\SomeText3.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            String[] parts = line.split(" ");
            for (String word : parts) {
                if (word.length() > 3) {
                    word = word.replace('.', ' ');
                    word = word.replaceAll("[!,-?]", "");
                    if (result.containsKey(word)) {
                        result.put(word, result.get(word) + 1);
                    } else {
                        result.put(word, 1);
                    }
                }
            }
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
