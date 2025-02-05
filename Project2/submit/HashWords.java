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

// self - this is just an arr of WordFrequency which is a string:int pair, easy
// self - toLowercase() already internally checks for any chars being lowercase
// before operating
public class HashWords {

    // fields
    private WordFrequency[] words;
    private int size;
    private int uniqueWords;
    private int totalWords;

    /**
     * Class constructor.
     * 
     * @param initialSize The starting size of the table.
     */
    public HashWords(int initialSize) {
        this.words = new WordFrequency[initialSize];
        this.size = initialSize;
        this.uniqueWords = 0;
        this.totalWords = 0;
    }

    /**
     * Returns the size of the table used internally
     * 
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Computes the key for argument w according to the specs of the Project.
     * 
     * @param w The word to find the key for.
     * @return The computed key
     */
    public int hashKey(String w) {
        w.toLowerCase();

        char[] wChars = w.toCharArray();
        int charValue = 0;
        for (int i = 0; i < w.length(); i++) {
            charValue += (int) wChars[i];
        }

        int ret = charValue % this.size();
        return ret;
    }

    /**
     * Implements the algorithm to add the given word (w) to the table.
     * 
     * @param w The word to add to the table.
     */
    public void addWord(String w) {
        w.toLowerCase();

        // 1.)
        int hashKey = this.hashKey(w);
        int wordIndex = this.getWordIndex(w); // initialized early since we use it in both cases

        // 2.)
        if (this.contains(w)) {
            this.words[wordIndex].increment();
            this.totalWords++;
            return;
        }

    }
    //
    // TODO - temp addWord() specifications for convenience
    // remember to increment uniqueWords and totalWords for relevant steps
    // the numeric annotations "#)." above are temp and should be deleted when done
    //
    // --DONE--
    // 1.) To add the word to the table, the algorithm should call hashKey() to get
    // the
    // index for the word.

    // --DONE--
    // 2.) Then, the algorithm should check to see if the word already exists in the
    // table. If it is, it simply increments the count stored in the WordFrequency
    // for that word and the work is done.

    // --NOT DONE--
    // 3.) If the word is not on the table, the algorithm should check if there is
    // space
    // in the table to store one more word. If there is, it should proceed to add
    // the word to the hash table.

    // --NOT DONE--
    // 4.) If there is no more space, the method should grow the array and rehash
    // all of
    // the words to add them back into the table. The new size needs to be 3 times
    // of the previous size. Only after expanding the table and rehashing all the
    // words, it should proceed to add the new word to the hash table.

    // --NOT DONE--
    // 5.) Note that adding a word to the table might require dealing with
    // collisions.
    // If there is a collision, use linear probing to find an empty location in the
    // table where the word will be stored.
    //
    //
    //

    /**
     * Does this hash table contain this word (w)?
     * 
     * @param w The word to find in the table.
     * @return True if the word is in the table, false otherwise.
     */
    public boolean contains(String w) {
        w.toLowerCase();

        if (this.getWordIndex(w) > -1)
            return true;
        else
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

        int index = this.getWordIndex(w);
        if (index > -1)
            return this.words[index].getCount(); // found
        else
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
            if (this.words[i] == null) {
                continue; // skip if table's index is empty or unassigned
            }
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
     *         the total number of words in the document. If not found, returns 0.0
     */
    public double termFrequency(String w) {
        w.toLowerCase();

        if (!this.contains(w)) {
            return 0.0;
        }
        double ret = this.frequency(w) / this.totalNumOfWords();
        return ret;
    }

    /**
     * Returns the index of word(w) in the table.
     * Self method - not required in specs.
     * 
     * @param w The word to find.
     * @return The index of the word if found. -1 if not found.
     */
    public int getWordIndex(String w) {
        for (int i = 0; i < this.size(); i++) {
            if (this.words[i] == null) {
                continue; // skip if table's index is empty or unassigned
            }
            if (this.words[i].getWord().equals(w)) {
                return this.words[i].getCount();
            }
        }
        return -1; // not found
    }
}
