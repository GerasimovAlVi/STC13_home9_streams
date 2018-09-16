package ru.innopolis.home_work_4;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClassThreadPool {

    private String[] strPath;
    private SingleParserFile singleParserFile;

    public ClassThreadPool(String[] strPath, SingleParserFile singleParserFile) {
        this.strPath = strPath;
        this.singleParserFile = singleParserFile;
    }

    public void createThreadPools() {
        ExecutorService executor = Executors.newFixedThreadPool(pool);
        for (int i = 0; i < pool; i++) {
            executor.execute(singleParserFile);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(60L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
