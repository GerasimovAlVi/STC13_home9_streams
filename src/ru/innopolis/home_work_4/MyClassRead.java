package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class MyClassRead {

    static String[] str = {"aaaaaaaaaa","spoyixflvvepa"};
    static String path1 = "d://Itog.txt";

    public static void main(String[] args) {
        System.out.println(read("d://file1.txt"));
        replace("d://file1.txt");
    }

    /*void findAndReplace(String path, String word, String newWord){
        System.out.println(read(path));
        System.out.println("");
        System.out.println(replace(path, word, newWord));
        write(path, word, newWord);
    }*/

    static String read(String path){
        String string = "";
        try(FileInputStream fileInputStream = new FileInputStream(path)){
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

    static void replace(String path){
        String string = read(path).replace("\r\n","")
                .replace(".", ".___")
                .replace("!", "!___")
                .replace("?", "?___");
        ArrayList<String> arrayList = new ArrayList<>();
        for(String i:string.split("___ ")){
            arrayList.add(i);
        }
        String string2 = new String();

        ArrayList<String> arrayList2 = new ArrayList<>();
        for(String i:str){
            arrayList2.add(i);
        }

        for(String j:arrayList){
            System.out.println(j);
            string2 += j + "__";
        }
        //System.out.println(string2);

        /*String string2 = string.replaceAll(word, newWord);
        string2 = string2.replaceAll(word.substring(0, 1).toUpperCase() + word.substring(1),
                newWord.substring(0, 1).toUpperCase() + newWord.substring(1));
        return string2;*/
    }

    /*static void write(String path, String word, String newWord){
        try(FileOutputStream fileOutputStream = new FileOutputStream(path)){
            byte[] buffer = replace(path, word, newWord).getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}
