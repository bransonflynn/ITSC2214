package Project2.submit;

import itsc2214.*;

/**
 * Custom object to store "words" as string:int key:value pair for use in
 * HashWords.java
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

public class WordFrequency {

    private String word;
    private int count;

    public WordFrequency(String w) {
        this.word = w;
        this.count = 1;
    }

    public String getWord() {
        return this.word;
    }

    public int getCount() {
        return this.count;
    }

    public void increment() {
        this.count++;
    }
}
