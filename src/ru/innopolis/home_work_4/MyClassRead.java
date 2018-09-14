package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MyClassRead {

    public static void main(String[] args) {
        /*
        System.out.println(read("d://file1.txt"));
        System.out.println("");
        System.out.println(find("d://file1.txt", str));
        write("d://file1.txt", str, "d://Itog.txt");*/
    }

    void findAndWrite(String[] strPath, String[] strWord, String pathWrite){
        for(String i:strPath){
            write(i, strWord, pathWrite);
        }
    }

    /*void findAndWrite(String pathRead, String[] strWord, String pathWrite){
        write(pathRead, strWord, pathWrite);
    }*/

    static String read(String pathRead){
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

    static String find(String pathRead, String[] strWord){
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
                if(i.contains(j)){
                    string2 += (i + " ");
                }
            }
        }
        return string2;
    }

    static void write(String pathRead , String[] strWord, String pathWrite){


        try(FileOutputStream fileOutputStream = new FileOutputStream(pathWrite)){
            byte[] buffer = find(pathRead, strWord).getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
