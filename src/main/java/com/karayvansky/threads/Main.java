package com.karayvansky.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> result = new HashMap<String, Integer>();
        HashMapFirst hashMapFirst = new HashMapFirst(result);
        HashMapSecond hashMapSecond = new HashMapSecond(result);
        HashMapThird hashMapThird = new HashMapThird(result);
        hashMapFirst.start();
        hashMapSecond.start();
        hashMapThird.start();
        FileOut fileOut = new FileOut(result);
        fileOut.insertMapToFile(new FileWriter("d:\\SomeTextAll.txt"));
    }
}
