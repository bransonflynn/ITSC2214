package Project2.submit;

import org.junit.Ignore;

/**
 * Custom object to store "words" as string:int key:value pair for use in
 * HashWords
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

public class WordFrequency {

    private String word;
    private int count;

    /**
     * Class constructor.
     * 
     * @param w The text that this word contains.
     */
    public WordFrequency(String w) {
        this.word = w;
        this.count = 1;
    }

    /**
     * Returns the text that this word contains.
     * 
     * @return The text that this word contains.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Returns the amount of times this word has appeared in the containing table.
     * 
     * @return The amount of times this word has appeared in the containing table.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Setter for count.
     * 
     * @param n The new count to set.
     */
    public void setCount(int n) {
        this.count = n;
    }

    /**
     * Increases the count of this word by 1.
     */
    public void increment() {
        this.count++;
    }

    /**
     * Decreases the count of this word by 1.
     */
    public void decrement() {
        this.count--;
        if (this.count < 0)
            this.count = 0;
    }

    /**
     * toString implementation for WordFrequency.
     * 
     * @return String representation of WordFrequency.
     */
    @Ignore
    public String toString() {
        return "WordFrequency{word=" + this.word + ", count=" + this.count + "}";
    }
}
