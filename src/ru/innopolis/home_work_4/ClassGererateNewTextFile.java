package ru.innopolis.home_work_4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class ClassGererateNewTextFile {

    private StringBuilder itogString = new StringBuilder();

    public void getOccurencies(URI[] uri, String[] strWord, String pathWrite, int pool) throws InterruptedException {
        ClassThreadPool classThreadPool = new ClassThreadPool();
        classThreadPool.createThreadPools(uri, strWord, itogString, pool);
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
