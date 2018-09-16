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
        //System.out.println("3+ " + System.currentTimeMillis());
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
        //System.out.println("4+ " + System.currentTimeMillis());
        return string.toString();
    }

    private void find(String strPath, String[] strWord) {
        //System.out.println("2+ " + System.currentTimeMillis());
        String string = read(strPath).replace("\r\n", "")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");
        //System.out.println("5+ " + System.currentTimeMillis());
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
        //System.out.println("6+ " + System.currentTimeMillis());
    }
}
