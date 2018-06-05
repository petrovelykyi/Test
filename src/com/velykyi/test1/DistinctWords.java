package com.velykyi.test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class DistinctWords {
    private String inFilePath;
    private RandomAccessFile inFile = null;
    private TreeSet<String> words = new TreeSet<>();

    public DistinctWords(String inFilePath) {
        this.inFilePath = inFilePath;
    }

    private boolean openFile(){
        File file = new File(inFilePath);

        if (file.isFile()) {
            try {
                this.inFile = new RandomAccessFile(inFilePath, "r");
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public void getDistinctWords(){
        if (this.openFile()) {
            System.out.println("OK");
            String tmpStr;
            try {
                while ((tmpStr = this.inFile.readLine()) != null){
                    StringTokenizer st = new StringTokenizer(tmpStr, " .,/-;:");
                    while (st.hasMoreTokens()){
                        this.words.add(st.nextToken().toLowerCase());
                    }
                }
                inFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Couldn't open file!!!");
        }
    }

    public void saveWordsToFile(String outFilePath){
        RandomAccessFile outFile = null;
        try {
            outFile = new RandomAccessFile(outFilePath, "rw");
            for (String el : words){
                outFile.writeBytes(el + "\n");
            }
            outFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printWords() {
        for (String el : words){
            System.out.println(el);
        }
    }
}
