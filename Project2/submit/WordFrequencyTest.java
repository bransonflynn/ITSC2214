package Project2.submit;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for WordFrequency.java to ensure proper coverage of methods.
 * 
 * @author Branson Flynn
 * @version Feb 04, 2025
 */

public class WordFrequencyTest {
    private WordFrequency wordFreq;

    @Before
    public void setup() {
        wordFreq = new WordFrequency("Shmungus");
    }

    @Test
    public void testOne() {
        assertEquals(wordFreq.getWord(), "Shmungus");
    }

    @Test
    public void testTwo() {
        assertEquals(wordFreq.getCount(), 1);
    }

    @Test
    public void testThree() {
        assertEquals(wordFreq.getCount(), 1);
        wordFreq.increment();
        assertEquals(wordFreq.getCount(), 2);
    }
}
