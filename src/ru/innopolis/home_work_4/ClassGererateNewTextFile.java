package ru.innopolis.home_work_4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ClassGererateNewTextFile {

    private StringBuilder itogString = new StringBuilder();
    private List<Thread> threads = new ArrayList<>();

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite) throws InterruptedException {
        ClassThreadPool classThreadPool = new ClassThreadPool(strPath, new SingleParserFile(path, strWord, itogString));
        classThreadPool.createThreadPools();
        ExecutorService executor;
        if ((strPath.length) > 10) {
            executor = Executors.newFixedThreadPool(10);
        } else {
            executor = Executors.newFixedThreadPool(strPath.length);
        }
        List<Callable<String>> tasks = new ArrayList<>();
        for (String path : strPath) {
            tasks.add(new SingleParserFile(path, strWord, itogString));
        }
        executor.invokeAll(tasks);
        executor.shutdown();
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
