package Project2.submit;

/**
 * This class implements a hash table.
 * 
 * It has an array of WordFrequency objects.
 * It implements a linear probing as a closed addressing approach to resolve
 * collisions.
 * 
 * It should use a simple hash function, as defined in hashKey that
 * adds the character value for each letter in the String and compute modulo
 * with the size of the table.
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

// self note - this is just an array of WordFrequency which is a string:int
// pair, easy
public class HashWords {

    private WordFrequency[] words;
    private int initialSize;
    private int uniqueWords;
    private int totalWords;

    public HashWords(int initialSize) {
        this.words = new WordFrequency[initialSize];
        this.initialSize = initialSize;
        this.uniqueWords = 0;
        this.totalWords = 0;
    }

    public int size() {
        return words.length;
    }

    public int hashKey(String w) {
        w.toLowerCase(); // case-insensitive

        char[] wChars = w.toCharArray();
        int charValue = 0;
        for (int i = 0; i < w.length(); i++) {
            charValue += wChars[i];
        }

        return charValue % this.size();
    }

    /**
     * Implements the algorithm to add the given word (w) to the table.
     * 
     * @param w The word to add to the table.
     */
    public void addWord(String w) {
        // TODO
        // note - be sure to check and increment uniqueWords++ if word is not found
        // note - same for totalWords, check spec
    }

    /**
     * Does this hash table contain this word (w)?
     * 
     * @param w The word to find in the table.
     * @return True if the word is in the table, false otherwise.
     */
    public boolean contains(String w) {
        w.toLowerCase();

        for (int i = 0; i < this.size(); i++) {
            if (this.words[i].getWord().equals(w)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the amount of times that word (w) is found in the table, if any.
     * 
     * @param w The word to find in the table.
     * @return The amount of times the word appears in the table. 0 if none.
     */
    public int frequency(String w) {
        w.toLowerCase();

        for (int i = 0; i < this.size(); i++) {
            if (this.words[i].getWord().equals(w)) {
                return this.words[i].getCount();
            }
        }
        return 0; // not found
    }

    /**
     * Computes the number of unique words stored in the table.
     * 
     * @return The number of unique words stored in the table.
     */
    public int numUniqueWordsInTable() {
        return this.uniqueWords;
    }

    /**
     * Computes the sum of all of the word counts in the table, regardless of
     * repetition.
     * 
     * @return The sum of all of the word counts in the table
     */
    public int totalNumOfWords() {
        return this.totalWords;
    }

    /**
     * Finds the word with the highest count of appearance in the table.
     * 
     * @return The word that was found.
     */
    public String mostCommonWord() {
        int foundValue = Integer.MIN_VALUE;
        int foundIndex = -1;

        for (int i = 0; i < this.size(); i++) {
            if (this.words[i].getCount() > foundValue) {
                foundValue = this.words[i].getCount();
                foundValue = i;
            }
        }

        return this.words[foundIndex].getWord();
    }

    /**
     * Computes how unique a word is in the particular collection of words.
     * 
     * @param w The word to search for.
     * @return The ratio of the number of times a particular word appears divided by
     *         the total number of words in the document.
     *         If not found, returns 0.0
     */
    public double termFrequency(String w) {
        w.toLowerCase();

        if (!this.contains(w)) {
            return 0.0;
        }
        double ret = this.frequency(w) / this.totalNumOfWords();
        return ret;
    }
}
