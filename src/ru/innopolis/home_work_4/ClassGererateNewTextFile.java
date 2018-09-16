package ru.innopolis.home_work_4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class ClassGererateNewTextFile {

    private StringBuilder itogString = new StringBuilder();

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite) throws InterruptedException {
        ClassThreadPool classThreadPool = new ClassThreadPool();
        classThreadPool.createThreadPools(strPath, strWord, itogString);
        /*ExecutorService executor;
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
        executor.shutdown();*/
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
