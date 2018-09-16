package ru.innopolis.home_work_4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ClassGererateNewTextFile {

    private StringBuilder itogString = new StringBuilder();
    private List<Thread> threads = new ArrayList<>();

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite, int pool) {
        for (String i : strPath) {
            /*Thread thread = new SingleParserFile(i, strWord, itogString);
            thread.start();
            threads.add(thread);*/
            ClassThreadPool classThreadPool = new ClassThreadPool(pool, new SingleParserFile(i, strWord, itogString));
            classThreadPool.createThreadPool();
        }
        /*for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
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
