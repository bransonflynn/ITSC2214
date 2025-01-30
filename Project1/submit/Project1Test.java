import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Project1 testcases for debugging.
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */
public class Project1Test {

    private Project1 runnerEven;
    private Project1 runnerOdd;
    private Project1 runnerEmpty;

    /**
     * Initializes common references for tests.
     */
    @Before
    public void setup() {
        runnerEven = new Project1(4);
        runnerEven.addValue(2);
        runnerEven.addValue(20);
        runnerEven.addValue(6);
        runnerEven.addValue(13);

        runnerOdd = new Project1(3);
        runnerOdd.addValue(3);
        runnerOdd.addValue(10);
        runnerOdd.addValue(12);

        runnerEmpty = new Project1(5);
    }

    /**
     * General test case.
     */
    @Test
    public void testOne() {
        assertNotNull(runnerEven);
        // assertFalse(runnerEven.isEmpty()); // better be empty
        // assertFalse(runnerEven.isFull()); // better NOT be full

        assertFalse(runnerEven.isEmpty());
        assertEquals(4, runnerEven.size());
    }

    /**
     * General test case.
     */
    @Test
    public void testTwo() {
        Project1 runnerLocal = new Project1(4);
        assertNotNull(runnerLocal);
        runnerLocal.addValue(1);
        runnerLocal.addValue(2);
        runnerLocal.addValue(3);
        runnerLocal.addValue(3);

        assertEquals(runnerLocal.getMinimum(), 1);
        assertEquals(runnerLocal.getMaximum(), 3);
        assertEquals(runnerLocal.getAverage(), 2.25, 0.0);
        assertEquals(runnerLocal.getRange(), 2);
        assertEquals(runnerLocal.getMedian(), 2.5, 0.0);
        assertEquals(runnerLocal.getSize(), 4);
        assertEquals(runnerLocal.getCapacity(), 4);
        assertEquals(runnerLocal.getValue(1), 2);
        assertEquals(runnerLocal.setValue(0, 1), 1);
        assertNotNull(runnerLocal);
        assertFalse(runnerLocal.isEmpty());
        assertTrue(runnerLocal.isFull());
        assertTrue(runnerLocal.hasDuplicates());
    }

    /**
     * Test cases for getter methods.
     */
    @Test
    public void testGetters() {
        assertNotNull(runnerEven.getArr());
        assertNotNull(runnerEven.getCapacity());
        assertNotNull(runnerEven.getSize());
    }

    /**
     * Test cases for getMinimum.
     */
    @Test
    public void testGetMinimum() {
        assertEquals(runnerEmpty.getMinimum(), Integer.MIN_VALUE);
        runnerEmpty.addValue(1);
        runnerEmpty.addValue(5);
        runnerEmpty.addValue(10);
        assertEquals(runnerEmpty.getMinimum(), 1);
    }

    /**
     * Test cases for getMaximum.
     */
    @Test
    public void testGetMaximum() {
        assertEquals(runnerEmpty.getMaximum(), Integer.MAX_VALUE);
        runnerEmpty.addValue(1);
        runnerEmpty.addValue(5);
        runnerEmpty.addValue(10);
        assertEquals(runnerEmpty.getMaximum(), 10);
    }

    /**
     * Test cases for getAverage.
     */
    @Test
    public void testGetAverage() {
        assertEquals(runnerEven.getAverage(), 10.25, 0.0);
    }

    /**
     * Test cases for getAverage where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testGetAverageThrows() {
        Project1 runnerLocal = new Project1(10);
        runnerLocal.getAverage(); // throws IllegalStateException
    }

    /**
     * Test cases for range calculation.
     */
    @Test
    public void testGetRange() {
        assertEquals(runnerEven.getRange(), 18);
    }

    /**
     * Test cases for getMedian calculation.
     */
    @Test
    public void testGetMedian() {
        Project1 runnerEvenEven = new Project1(2);
        runnerEvenEven.addValue(2);
        runnerEvenEven.addValue(4);

        Project1 runnerEvenOdd = new Project1(3);
        runnerEvenOdd.addValue(1);
        runnerEvenOdd.addValue(3);
        runnerEvenOdd.addValue(5);

        assertEquals(runnerEvenEven.getMedian(), 3.0, 0.0);
        assertEquals(runnerEvenOdd.getMedian(), 3.0, 0.0);
    }

    /**
     * Test cases for size equality.
     */
    @Test
    public void testSize() {
        assertEquals(runnerEven.size(), runnerEven.getSize());
    }

    /**
     * Test cases for Capacity.
     */
    @Test
    public void testCapacity() {
        assertEquals(runnerEven.capacity(), runnerEven.getCapacity());
    }

    /**
     * Test cases for addValue where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddValueThrows() {
        Project1 runnerLocal = new Project1(0);
        runnerLocal.addValue(5); // throws IllegalStateException
    }

    /**
     * Test cases for getValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows1() {
        Project1 runnerLocal = new Project1(4);
        runnerLocal.getValue(6); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for getValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueThrows2() {
        Project1 runnerLocal = new Project1(4);
        runnerLocal.getValue(-1); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for setValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows1() {
        Project1 runnerLocal = new Project1(4);
        runnerLocal.setValue(6, 2); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for setValue where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueThrows2() {
        Project1 runnerLocal = new Project1(4);
        runnerLocal.setValue(-1, 2); // throws IndexOutOfBoundsException
    }

    /**
     * Test cases for addRandom.
     */
    @Test
    public void testAddRandom() {
        runnerEmpty.addRandom(1); // throws IllegalStateException
    }

    /**
     * Test cases for addRandom where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddRandomThrows1() {
        Project1 runnerLocal = new Project1(3);
        runnerLocal.addRandom(6); // throws IllegalStateException
    }

    /**
     * Test cases for addRandom where an exception would be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void testAddRandomThrow2() {
        Project1 runnerLocal = new Project1(1);
        runnerLocal.addRandom(1);
        runnerLocal.addRandom(1); // throws IllegalStateException
    }

    /**
     * Test cases for removeValueAt.
     */
    @Test
    public void testRemoveValueAt() {
        assertEquals(runnerEven.size(), 4);
        runnerEven.removeValueAt(1);
        assertEquals(runnerEven.size(), 3);
    }

    /**
     * Test cases for removeValueAt where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows1() {
        Project1 runnerLocal = new Project1(5);
        runnerLocal.removeValueAt(6); // throws IndexOutOfBoundsException

    }

    /**
     * Test cases for removeValueAt where an exception would be thrown.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtThrows2() {
        Project1 runnerLocal = new Project1(5);
        runnerLocal.removeValueAt(-1); // throws IndexOutOfBoundsException

    }

    /**
     * Test cases for isEmpty.
     */
    @Test
    public void testIsEmpty() {
        Project1 runnerLocal = new Project1(3);
        assertTrue(runnerLocal.isEmpty());
        assertFalse(runnerEven.isEmpty());
    }

    /**
     * Test cases for isFull.
     */
    @Test
    public void testIsFull() {
        assertFalse(runnerEmpty.isFull());
        assertTrue(runnerEven.isFull());
    }

    /**
     * Test cases for hasDuplicates.
     */
    @Test
    public void testHasDuplicates() {
        Project1 runnerEven = new Project1(5);
        runnerEven.addValue(1);
        runnerEven.addValue(2);
        runnerEven.addValue(3);
        runnerEven.addValue(4);
        assertFalse(runnerEven.hasDuplicates());
        runnerEven.addValue(4);
        assertTrue(runnerEven.hasDuplicates());
    }
}
