package com.musicg.main.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;

public class FingerprintTest{
    public static void main(String[] args){
        try {
            String outString = "";
            FileInputStream fis = new FileInputStream("out/Most Beautiful Girl in the Room.wav.fingerprint");
            PrintWriter pw = new PrintWriter("out/bytes.txt");
            int i = fis.read();
            while(i != -1){
                System.out.println(i);
                outString += i + "\n";
                i = fis.read();
            }

            pw.println(outString);
            pw.close();
        }catch(FileNotFoundException e){
            System.out.println("Error: file not found");
        }catch(IOException e){
            System.out.println("IOException");
        }

        System.out.println("All done!");
    }
}