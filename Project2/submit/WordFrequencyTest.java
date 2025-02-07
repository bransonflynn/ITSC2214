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
    private WordFrequency runner;

    @Before
    public void setup() {
        runner = new WordFrequency("Shmunguss");
    }

    @Test
    public void testGetWord() {
        assertEquals(runner.getWord(), "Shmunguss");
    }

    @Test
    public void testGetCount() {
        assertEquals(runner.getCount(), 1);
        runner.increment();
        assertEquals(runner.getCount(), 2);
    }

    @Test
    public void testSetCount() {
        assertEquals(runner.getCount(), 1);
        runner.setCount(100);
        assertEquals(runner.getCount(), 100);
    }

    @Test
    public void testIncrement() {
        assertEquals(runner.getCount(), 1);
        runner.increment();
        assertEquals(runner.getCount(), 2);
    }

    @Test
    public void testDecrement() {
        assertEquals(runner.getCount(), 1);
        runner.decrement();
        assertEquals(runner.getCount(), 0);
        runner.decrement();
        assertEquals(runner.getCount(), 0); // goes to -1, reset to 0
    }

    @Test
    public void testToString() {
        // static representation for test readability
        String toStringResult = "WordFrequency{word=Shmunguss, count=1}";
        assertEquals(runner.toString(), toStringResult);
    }
}
