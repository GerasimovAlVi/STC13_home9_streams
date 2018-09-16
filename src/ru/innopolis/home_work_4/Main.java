package ru.innopolis.home_work_4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*Long startTime1 = System.currentTimeMillis();
        ClassGenerateText classGenerateText = new ClassGenerateText();
        String[] words = new String[]{"aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc"};
        classGenerateText.getFile("d://", 1, 145000, words, 1);
        System.out.println("Время записи файлов: " + (System.currentTimeMillis() - startTime1));*/

        System.out.println("1:" + System.currentTimeMillis());
        Long startTime2 = System.currentTimeMillis();
        ClassGererateNewTextFile classGererateNewTextFile = new ClassGererateNewTextFile();
        String[] strPath = {"d://file1.txt"};
        //String[] strWord = {"bbbbbbbbbb", "cccccccccc"};
        String[] strWord = {"bbbbbbbbbb"};
        //String[] strPath = {"d://file1.txt", "d://file2.txt", "d://file3.txt", "d://file4.txt", "d://file5.txt"};
        classGererateNewTextFile.getOccurencies(strPath, strWord, "d://Itog.txt");
        System.out.println("Время анализа файлов и записи в один файл: " + (System.currentTimeMillis() - startTime2));
    }
}
