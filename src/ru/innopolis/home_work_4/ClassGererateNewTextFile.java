package ru.innopolis.home_work_4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ClassGererateNewTextFile {

    private StringBuilder itogString = new StringBuilder();
    private List<Thread> threads = new ArrayList<>();

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite, int pool) {
        for (int i = 0; i < strPath.length; i++) {
            ExecutorService executor = Executors.newFixedThreadPool(strPath.length);
            executor.execute(new SingleParserFile(strPath[i], strWord, itogString));
            executor.shutdown();
            try {
                executor.awaitTermination(60L, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        write(pathWrite);
    }

    private void write(String pathWrite) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathWrite))) {
            writer.write(itogString.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
