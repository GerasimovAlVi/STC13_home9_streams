package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SingleParserFile extends Thread {

    private String strPath;
    private String[] strWord;
    private StringBuilder itogString;

    public SingleParserFile(String strPath, String[] strWord, StringBuilder itogString) {
        this.strPath = strPath;
        this.strWord = strWord;
        this.itogString = itogString;
    }

    @Override
    public void run() {
        find(strPath, strWord);
    }

    private String read(String strPath) {
        String string = "";
        try (FileInputStream fileInputStream = new FileInputStream(strPath)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                string += (char) i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
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
        String string2 = "";
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
                    string2 += (i + " ");
                }
            }
        }
        synchronized (itogString) {
            itogString.append(string2);
        }
    }
}
