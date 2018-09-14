package ru.innopolis.home_work_4;

public class Main {
    public static void main(String[] args) {
        MyMainMethod myMainMethod = new MyMainMethod();
        String[] words = new String[]{"aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc"};
        myMainMethod.getFile("d://", 5, 50, words,1);
    }
}
