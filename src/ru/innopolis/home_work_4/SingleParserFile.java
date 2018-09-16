package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        StringBuilder string = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(strPath)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                string.append((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
    }

    private void find(String strPath, String[] strWord) {
        String string = read(strPath).replace("\r\n", "")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");
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
    }
}
