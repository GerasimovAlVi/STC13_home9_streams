package ru.innopolis.home_work_4;

import java.net.URI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Long startTime2 = System.currentTimeMillis();
        ClassGererateNewTextFile classGererateNewTextFile = new ClassGererateNewTextFile();
        String[] strWord = {"bbbbbbbbbb"};
        URI[] uri = {URI.create("d://file1.txt"),
                URI.create("d://file2.txt"),
                URI.create("d://file3.txt"),
                URI.create("d://file4.txt"),
                URI.create("d://file5.txt")};
        classGererateNewTextFile.getOccurencies(uri, strWord, "d://Itog.txt", 5);
        System.out.println("Время анализа файлов и записи в один файл: " + (System.currentTimeMillis() - startTime2));
    }
}
