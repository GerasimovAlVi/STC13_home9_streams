package ru.innopolis.home_work_4;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassThreadPool {

    public void createThreadPools(String[] strPath, String[] strWord, StringBuilder itogString, int pool) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(pool);
        List<Callable<String>> tasks = new ArrayList<>();
        for (String path : strPath) {
            tasks.add(new SingleParserFile(path, strWord, itogString));
        }
        executor.invokeAll(tasks);
        executor.shutdown();
    }
}
