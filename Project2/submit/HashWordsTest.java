package Project2.submit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for HashWords.java to ensure proper coverage of methods.
 * 
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

public class HashWordsTest {

    private HashWords hash;

    @Before
    public void setup() {
        hash = new HashWords(4);
    }

    /**
     * General test case for combo operations.
     */
    @Test
    public void testOne() {
        assertNotNull(hash);
        hash.addWord("Shmunguss");
        assertTrue(hash.contains("Shmunguss"));
        hash.addWord("Shmunguss");
        assertEquals(hash.frequency("Shmunguss"), 2);
    }

    /**
     * Test cases for hashKey() method.
     */
    @Test
    public void testHashKey() {
        assertEquals(hash.hashKey("hello"), 0);
    }

    /**
     * Test cases for contains() method.
     */
    @Test
    public void testContains() {
        hash.addWord("Shmunguss");
        assertTrue(hash.contains("Shmunguss"));
        assertFalse(hash.contains("Bungus"));
    }

    /**
     * Test caess for frequency() method.
     */
    @Test
    public void testFrequency() {
        hash.addWord("Shmunguss");
        assertEquals(hash.frequency("Shmunguss"), 1);
        assertEquals(hash.frequency("Bungus"), 0);
    }

    /**
     * Test cases for numUniqueWordsInTable() method.
     */
    @Test
    public void testNumUniqueWordsInTable() {
        hash.addWord("Shmunguss");
        assertEquals(hash.numUniqueWordsInTable(), 1);
        hash.addWord("Bungus");
        assertEquals(hash.numUniqueWordsInTable(), 2);
    }

    /**
     * Test cases for totalNumOfWords() method.
     */
    @Test
    public void testTotalNumOfWords() {
        hash.addWord("Shmunguss");
        assertEquals(hash.totalNumOfWords(), 1);
        hash.addWord("Bungus");
        assertEquals(hash.totalNumOfWords(), 2);
    }

    /**
     * Test cases for mostCommonWord() method.
     */
    @Test
    public void testMostCommonWord() {
        hash.addWord("Shmunguss");
        hash.addWord("Shmunguss");
        hash.addWord("Bungus");
        assertEquals(hash.mostCommonWord(), "Shmunguss");
        assertNotEquals(hash.mostCommonWord(), "Bungus");
    }

    /**
     * Test cases for termFrequency() method.
     */
    @Test
    public void testTermFrequency() {
        hash.addWord("Shmunguss");
        hash.addWord("Shmunguss");
        hash.addWord("Shmunguss");
        hash.addWord("Bungus");
        assertEquals(hash.termFrequency("Shmunguss"), 0.75, 0.0);
        assertEquals(hash.termFrequency("Scungus"), 0.0, 0.0);
    }

    /**
     * Test cases for linearProbe() method.
     */
    @Test
    public void testLinearProbe() {
        assertEquals(hash.linearProbe(), 0);
        hash.addWord("("); // ascii=40
        assertEquals(hash.linearProbe(), 1);
        hash.addWord(")"); // ascii=41
        hash.addWord("*"); // ascii=42
        hash.addWord("+"); // ascii=43
        assertEquals(hash.linearProbe(), -1);
    }
}
