package ru.innopolis.home_work_4;

public class Main {
    public static void main(String[] args) {



        MyClassRead myClassRead = new MyClassRead();
        String[] strWord = {"bbbbbbbbbb","spoyixflvvepa"};
        String[] strPath = {"d://file1.txt","d://file2.txt","d://file3.txt","d://file4.txt","d://file5.txt"};
        myClassRead.findAndWrite(strPath, strWord, "d://Itog.txt");
    }
}
