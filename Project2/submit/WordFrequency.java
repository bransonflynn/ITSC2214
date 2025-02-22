package Project2.submit;

import org.junit.Ignore;

/**
 * Custom object to store "words" as string:int key:value pair for use in
 * HashWords
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

public class WordFrequency implements Comparable<WordFrequency> {

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
     * Comparable implementation.
     * 
     * @param other The other object to compare against.
     * @return Value of member word String comparison value.
     *         Falls back to member count comparison value if word comparison is equal.
     */
    public int compareTo(WordFrequency other) {
        int wordComp = this.getWord().compareTo(other.getWord());
        if (wordComp != 0) {
            return wordComp;
        }

        if (this.getCount() == other.getCount()) {
            return 0;
        } else if (this.getCount() < other.getCount()) {
            return -1;
        } else { // this.getCount() > other.getCount()
            return 1;
        }
    }
}
