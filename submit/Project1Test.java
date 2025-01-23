//import itsc2214.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import itsc2214.ArrayInt;

/**
 * TODO Write a one-sentence summary of your here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */
public class Project1Test {

    @Test
    public void testOne() {
        Project1 nums = new Project1(10);
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
    }

    @Test
    public void testTwo() {
        Project1 nums = new Project1(4);
        assertNotNull(nums);
        nums.addValue(1);
        nums.addValue(2);
        nums.addValue(3);
        nums.addValue(3);

        assertEquals(nums.getMinimum(), 1);
        assertEquals(nums.getMaximum(), 3);
        assertEquals(nums.getAverage(), 2.25, 0.0);
        assertEquals(nums.getRange(), 2);
        assertEquals(nums.getMedian(), 2.5, 0.0);
        assertEquals(nums.getSize(), 4);
        assertEquals(nums.getCapacity(), 4);
        assertEquals(nums.getValue(1), 2);
        assertEquals(nums.setValue(0, 1), 1);
        // addRandom()
        // removeValueAt()
        assertFalse(nums.isEmpty());
        assertTrue(nums.isFull());
        assertTrue(nums.hasDuplicates());
    }

    @Test
    public void testGetters() {
        Project1 nums = new Project1(10);
        assertNotNull(nums.getArr());
        assertNotNull(nums.getCapacity());
        assertNotNull(nums.getSize());
    }

    @Test
    public void testGetMinimum() {
        Project1 numsEmpty = new Project1(0);
        assertEquals(numsEmpty.getMinimum(), Integer.MIN_VALUE);

        Project1 nums = new Project1(3);
        nums.addValue(1);
        nums.addValue(5);
        nums.addValue(10);
        assertEquals(nums.getMinimum(), 1);
    }

    @Test
    public void testGetMaximum() {
        Project1 numsEmpty = new Project1(0);
        assertEquals(numsEmpty.getMaximum(), Integer.MAX_VALUE);

        Project1 nums = new Project1(3);
        nums.addValue(1);
        nums.addValue(5);
        nums.addValue(10);
        assertEquals(nums.getMaximum(), 10);
    }

    @Test
    public void testGetAverage() {
        Project1 nums = new Project1(3);
        nums.addValue(1);
        nums.addValue(5);
        nums.addValue(12);
        assertEquals(nums.getAverage(), 6.0, 0.0);

        Project1 numsEmpty = new Project1(0);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            numsEmpty.getAverage();
        });
        assertEquals("The array was empty.", exception.getMessage());
    }

    @Test
    public void testGetRange() {
        Project1 nums = new Project1(3);
        nums.addValue(1);
        nums.addValue(5);
        nums.addValue(12);
        assertEquals(nums.getRange(), 11);
    }

    @Test
    public void testGetMedian() {
        Project1 numsEven = new Project1(2);
        numsEven.addValue(2);
        numsEven.addValue(4);

        Project1 numsOdd = new Project1(3);
        numsOdd.addValue(1);
        numsOdd.addValue(3);
        numsOdd.addValue(5);

        assertEquals(numsEven.getMedian(), 3.0, 0.0);
        assertEquals(numsOdd.getMedian(), 3.0, 0.0);
    }

    @Test
    public void testSize() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        assertEquals(nums.size(), nums.getSize());
    }

    @Test
    public void testCapacity() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        assertEquals(nums.capacity(), nums.getCapacity());
    }

    @Test
    public void testAddValue() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            nums.addValue(5);
        });
        assertEquals("The array was full.", exception.getMessage());
    }

    @Test
    public void testGetValue() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.getValue(3);
        });
        assertEquals("The provided position at the index was not valid.", exception1.getMessage());

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.getValue(-1);
        });
        assertEquals("The provided position at the index was not valid.", exception2.getMessage());
    }

    @Test
    public void setValue() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.setValue(3, 1);
        });
        assertEquals("The provided position at the index was not valid.", exception1.getMessage());

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.setValue(-1, 1);
        });
        assertEquals("The provided position at the index was not valid.", exception2.getMessage());
    }

    @Test
    public void testAddRandom() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        IllegalStateException exception1 = assertThrows(IllegalStateException.class, () -> {
            nums.addRandom(1);
        });
        assertEquals("The array was full.", exception1.getMessage());
    }

    @Test
    public void testRemoveValuesAt() {
        Project1 nums = new Project1(2);
        nums.addValue(2);
        nums.addValue(4);
        IndexOutOfBoundsException exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.removeValueAt(3);
        });
        assertEquals("The provided position at the index was not valid.", exception1.getMessage());

        IndexOutOfBoundsException exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            nums.removeValueAt(-1);
        });
        assertEquals("The provided position at the index was not valid.", exception2.getMessage());
    }

    @Test
    public void testIsEmpty() {
        Project1 nums = new Project1(5);
        assertTrue(nums.isEmpty());
        nums.addValue(1);
        assertFalse(nums.isEmpty());
    }

    @Test
    public void testIsFull() {
        Project1 nums = new Project1(1);
        assertFalse(nums.isFull());
        nums.addValue(1);
        assertTrue(nums.isFull());
    }

    @Test
    public void testHasDuplicates() {
        Project1 nums = new Project1(5);
        nums.addValue(1);
        nums.addValue(2);
        nums.addValue(3);
        nums.addValue(4);
        assertFalse(nums.hasDuplicates());
        nums.addValue(4);
        assertTrue(nums.hasDuplicates());
    }
}
