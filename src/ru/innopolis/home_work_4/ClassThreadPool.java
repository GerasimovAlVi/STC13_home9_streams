package ru.innopolis.home_work_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassThreadPool {

    private int pool;
    private SingleParserFile singleParserFile;

    public ClassThreadPool(int pools, SingleParserFile singleParserFile) {
        this.pool = pool;
        this.singleParserFile = singleParserFile;
    }

    public void createThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(pool);
        for (int i = 0; i < pool; i++) {
            executorService.execute(singleParserFile);
        }
        executorService.shutdown();
    }
}
