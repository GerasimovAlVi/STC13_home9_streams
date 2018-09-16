package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SingleParserFile extends Thread {

    private String pathRead;
    private String[] strWord;
    private StringBuilder itogString;

    public SingleParserFile(String pathRead, String[] strWord, StringBuilder itogString) {
        this.pathRead = pathRead;
        this.strWord = strWord;
        this.itogString = itogString;
    }

    @Override
    public void run() {
        find(pathRead, strWord);
    }

    private String read(String pathRead) {
        String string = "";
        try (FileInputStream fileInputStream = new FileInputStream(pathRead)) {
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

    private void find(String pathRead, String[] strWord) {
        String string = read(pathRead).replace("\r\n", "")
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
