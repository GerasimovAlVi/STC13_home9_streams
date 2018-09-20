package ru.innopolis.home_work_4;

import java.net.URI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Long startTime1 = System.currentTimeMillis();
        ClassGenerateText classGenerateText = new ClassGenerateText();
        String[] words = new String[]{"aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc"};
        classGenerateText.getFile("d://", 5, 50000, words, 1);
        System.out.println("Время записи файлов: " + (System.currentTimeMillis() - startTime1));

        System.out.println("1:" + System.currentTimeMillis());
        Long startTime2 = System.currentTimeMillis();
        ClassGererateNewTextFile classGererateNewTextFile = new ClassGererateNewTextFile();
        //String[] strWord = {"bbbbbbbbbb", "cccccccccc"};
        String[] strWord = {"bbbbbbbbbb"};
        //URI[] strPath = {URI.create("d://file1.txt")};
        URI[] uri = {URI.create("d://file1.txt"), URI.create("d://file2.txt"),
                URI.create("d://file3.txt"), URI.create("d://file4.txt"), URI.create("d://file5.txt")};
        classGererateNewTextFile.getOccurencies(uri, strWord, "d://Itog.txt", 5);
        System.out.println("Время анализа файлов и записи в один файл: " + (System.currentTimeMillis() - startTime2));
    }
}
