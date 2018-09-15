package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MyClassRead {

    public void getOccurencies(String[] strPath, String[] strWord, String pathWrite) {
        try (FileOutputStream writer = new FileOutputStream(pathWrite)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String i : strPath) {
            write(i, strWord, pathWrite);
        }
    }

    private static String read(String pathRead) {
        String string = "";
        try(FileInputStream fileInputStream = new FileInputStream(pathRead)){
            int i;
            while((i = fileInputStream.read()) != -1){
                string += (char) i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    private static String find(String pathRead, String[] strWord) {
        String string = read(pathRead).replace("\r\n","")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");
        ArrayList<String> arrayList = new ArrayList<>();
        for(String i:string.split("___ ")){
            arrayList.add(i);
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        for(String i:strWord){
            arrayList2.add(i);
        }
        String string2 = "";
        for(String i:arrayList){
            for(String j:arrayList2){
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
        return string2;
    }

    private static void write(String pathRead, String[] strWord, String pathWrite) {
        String string = "";
        try(FileInputStream fileInputStream = new FileInputStream(pathWrite)){
            int i;
            while((i = fileInputStream.read()) != -1){
                string += (char) i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(pathWrite)){
            String strItog = string + find(pathRead, strWord);
            byte[] buffer = strItog.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
