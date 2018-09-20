package ru.innopolis.home_work_4;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassThreadPool {

    public void createThreadPools(URI[] uri, String[] strWord, StringBuilder itogString, int pool) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(pool);
        List<Callable<String>> tasks = new ArrayList<>();
        for (URI ur : uri) {
            tasks.add(new SingleParserFile(ur.toString(), strWord, itogString));
        }
        executor.invokeAll(tasks);
        executor.shutdown();
    }
}
