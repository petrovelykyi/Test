package com.velykyi.test1;

public class Main {
    public static void main(String[] args) {
        DistinctWords dw = new DistinctWords("./src/com/velykyi/test1/in.txt");
        dw.getDistinctWords();
        dw.printWords();
        dw.saveWordsToFile("./src/com/velykyi/test1/out.txt");
    }
}
