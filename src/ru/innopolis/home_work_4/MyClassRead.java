package ru.innopolis.home_work_4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyClassRead {

    private String itogString = "";
    private List<Thread> threads = new ArrayList<>();

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite) {
        /*try (FileOutputStream writer = new FileOutputStream(pathWrite)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        String qwert = "";
        for (String i : strPath) {
            SingleParserFile thread = new SingleParserFile(i, strWord, itogString);
            thread.start();
            qwert = thread.getItogString();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(qwert);
        write(pathWrite);
    }

    private void write(String pathWrite) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(pathWrite)){
            byte[] buffer = itogString.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try(BufferedWriter writer = new BufferedWriter(new FileWriter(pathWrite))) {
            writer.write(itogString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
