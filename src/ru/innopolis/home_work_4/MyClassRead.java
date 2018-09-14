package ru.innopolis.home_work_4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyClassRead {

    public void read(String path){
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
        System.out.println(string);
    }
}
