//import itsc2214.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import itsc2214.ArrayInt;

/**
 * TODO Write a one-sentence summary of your here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author TODO Put Your Name in the author tag
 * @version Jan 16, 2025
 */
public class Project1Test {
    @Test
    public void testOne() {
        ArrayInt nums = new Project1(10);
        assertNotNull(nums);
        assertTrue(nums.isEmpty()); // better be empty
        assertFalse(nums.isFull()); // better NOT be full

        nums.addValue(100);
        assertFalse(nums.isEmpty()); // no longer empty
        assertEquals(1, nums.size()); // has 1 value
        nums.addValue(19);
        nums.addValue(19);
        nums.addValue(25);
        assertEquals(4, nums.size()); // has 4 values
        /// ... etc ../
    }
}
