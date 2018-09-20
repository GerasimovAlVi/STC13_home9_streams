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
        find(strPath, strWord);
        return itogString.toString();
    }

    /*private String read(String strPath) {
        System.out.println("2:" + System.currentTimeMillis());
        StringBuilder text = new StringBuilder();
        String string = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(strPath))) {
            while ((string = bufferedReader.readLine()) != null) {
                text.append(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("3:" + System.currentTimeMillis());
        return text.toString();
    }*/

    private void find(String strPath, String[] strWord) {
        /*String string = read(strPath).replace("\r\n", "")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");*/

        /*String string = null;
        try {
            string = Files.lines(Paths.get(strPath)).map(s->s.replaceAll("\r\n", ""))
                    .map(s->s.replaceAll("\\.",".___"))
                    .map(s->s.replaceAll("!","!___"))
                    .map(s->s.replaceAll("\\?","?___"))
                    .collect(Collectors.joining(""));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        System.out.println("4:" + System.currentTimeMillis());

        /*List<String> arrayList = new ArrayList<>();
        for (String i : string.split("___ ")) {
            arrayList.add(i);
        }*/

        List<String> arrayList = new ArrayList<>();
        try {
            arrayList = Files.lines(Paths.get(strPath)).map(s -> s.replaceAll("\r\n", ""))
                    .map(s -> s.replaceAll("\\.", ".___"))
                    .map(s -> s.replaceAll("!", "!___"))
                    .map(s -> s.replaceAll("\\?", "?___"))
                    .flatMap((p) -> Arrays.asList(p.split("___ ")).stream()).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
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
