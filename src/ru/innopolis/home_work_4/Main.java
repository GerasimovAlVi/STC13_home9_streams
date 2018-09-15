package ru.innopolis.home_work_4;

public class Main {
    public static void main(String[] args) {
        /*MyMainMethod myMainMethod = new MyMainMethod();
        String[] words = new String[]{"aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc"};
        myMainMethod.getFile("d://", 5, 50, words, 1);*/

        MyClassRead myClassRead = new MyClassRead();
        String[] strWord = {"bbbbbbbbbb", "cccccccccc"};
        String[] strPath = {"d://file1.txt","d://file2.txt","d://file3.txt","d://file4.txt","d://file5.txt"};
        myClassRead.getOccurencies(strPath, strWord, "d://Itog.txt");
    }
}
