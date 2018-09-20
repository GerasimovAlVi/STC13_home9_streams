package ru.innopolis.home_work_4;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassThreadPool {

    public void createThreadPools(URI[] uri, String[] strWord, StringBuilder itogString, int pool) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(pool);
        List<Callable<String>> tasks = new ArrayList<>();
        Arrays.stream(uri).forEach(i -> tasks.add(new SingleParserFile(i.toString(), strWord, itogString)));
        executor.invokeAll(tasks);
        executor.shutdown();
    }
}
