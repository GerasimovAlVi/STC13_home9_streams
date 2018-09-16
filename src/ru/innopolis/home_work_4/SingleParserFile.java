package ru.innopolis.home_work_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SingleParserFile implements Callable<String> {

    private String strPath;
    private String[] strWord;
    private StringBuilder itogString;

    public SingleParserFile(String strPath, String[] strWord, StringBuilder itogString) {
        this.strPath = strPath;
        this.strWord = strWord;
        this.itogString = itogString;
    }

    @Override
    public String call() {
        find(strPath, strWord);
        return itogString.toString();
    }

    private String read(String strPath) {
        System.out.println("2:" + System.currentTimeMillis());
        StringBuilder string = new StringBuilder();
        String sstring = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(strPath))) {
            while ((sstring = bufferedReader.readLine()) != null) {
                string.append(sstring);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3:" + System.currentTimeMillis());
        return string.toString();
    }

    private void find(String strPath, String[] strWord) {
        String string = read(strPath).replace("\r\n", "")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");
        System.out.println("4:" + System.currentTimeMillis());
        ArrayList<String> arrayList = new ArrayList<>();
        for (String i : string.split("___ ")) {
            arrayList.add(i);
        }
        StringBuilder string2 = new StringBuilder();
        for (String i : arrayList) {
            for (String j : strWord) {
                if ((i.contains(" " + j + " ")) ||
                        (i.contains(" " + j + ".")) ||
                        (i.contains(" " + j + "!")) ||
                        (i.contains(" " + j + "?")) ||
                        (i.contains(j.substring(0, 1).toUpperCase() + j.substring(1) + " ")) ||
                        (i.contains(j.substring(0, 1).toUpperCase() + j.substring(1) + ".")) ||
                        (i.contains(j.substring(0, 1).toUpperCase() + j.substring(1) + "!")) ||
                        (i.contains(j.substring(0, 1).toUpperCase() + j.substring(1) + "?"))) {
                    string2.append(i + " ");
                }
            }
        }
        synchronized (itogString) {
            itogString.append(string2);
        }
        System.out.println("5:" + System.currentTimeMillis());
    }
}
