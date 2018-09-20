package ru.innopolis.home_work_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

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
        read_find(strPath, strWord);
        return itogString.toString();
    }

    private void read_find(String strPath, String[] strWord) {
        List<String> arrayList = new ArrayList<>();
        try {
            arrayList = Files.lines(Paths.get(strPath)).map(s -> s.replaceAll("\r\n", ""))
                    .map(s -> s.replaceAll("\\.", ".___"))
                    .map(s -> s.replaceAll("!", "!___"))
                    .map(s -> s.replaceAll("\\?", "?___"))
                    .flatMap(p -> Arrays.asList(p.split("___ ")).stream()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder text = new StringBuilder();
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
                    text.append(i + " ");
                }
            }
        }
        synchronized (itogString) {
            itogString.append(text);
        }
    }
}
