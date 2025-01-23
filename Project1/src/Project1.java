import java.util.Arrays;
import java.util.HashMap;

import itsc2214.ArrayInt;

/**
 * int[] wrapper class for ITSC2214 Project1
 * 
 * @author Branson Flynn
 * @version Jan 16, 2025
 */

// todo - add javadoc for params for methods

public class Project1 implements ArrayInt {

    private int[] arr;
    final private int capacity;
    private int size;

    /**
     * Class constructor.
     * 
     * @param capacity The maximum capacity of elements in the created instance.
     */
    public Project1(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int[] getArr() {
        return arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    /**
     * Finds the smallest item in the internal array.
     * If the array is empty, this returns Integer.MIN_VALUE.
     * 
     * @return The smallest number in the internal array.
     */
    public int getMinimum() {
        if (this.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result) {
                result = arr[i];
            }
        }
        return result;
    }

    /**
     * Finds the largest item in the internal array.
     * If the array is empty, this returns Integer.MAX_VALUE.
     * 
     * @return The largest number in the internal array.
     */
    public int getMaximum() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }

    /**
     * Computes the average of all values in the internal array. The last division
     * operation is how the average is found.
     * 
     * @return The average of all values in the internal array.
     * @throws IllegalStateException The array was empty.
     */
    public int getAverage() throws IllegalStateException {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result /= size();
    }

    /**
     * Computes the arithmetic difference between the largest and smallest value in
     * the internal array.
     * 
     * @return The arithmetic difference between the smallest and largest value in
     *         the internal array.
     */
    public int getRange() {
        return this.getMaximum() - this.getMinimum();
    }

    /**
     * Computes the most frequent value in the internal array.
     * 
     * @return The most frequent value found in the array.
     */
    public int getMode() { // todo
        return Integer.MAX_VALUE;
    }

    /**
     * 
     * @return
     */
    public int getMedian() {
        int[] arrSorted = Arrays.copyOf(arr, arr.length);
        if (arrSorted.length % 2 == 0) {
            // todo
        } else {
            return arrSorted[arrSorted.length / 2 + 1]; // todo - needs to be tested
        }
        return -1; // temp
    }

    /**
     * 
     */
    @Override
    public int size() {
        return this.getSize();
    }

    // returns the size of the array, that is how big the array is, not how many
    // elements are stored in it.
    public int capacity() {
        return this.getCapacity();
    }

    /**
     * 
     */
    @Override
    public void addValue(int value) throws IllegalStateException {
        this.size++;

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addValue'");
    }

    /**
     * Returns the value at the provided index of the internal array.
     * 
     * @param index The position to return the value from.
     * @return The value at the provided index.
     * @throws IndexOutOfBoundsException The provided position was not valid.
     */
    @Override
    public int getValue(int index) throws IndexOutOfBoundsException {
        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    /**
     * 
     */
    @Override
    public int setValue(int index, int value) throws IndexOutOfBoundsException {
        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int result = arr[index];
        arr[index] = value;
        return result;
    }

    /**
     * 
     */
    @Override
    public void addRandom(int n) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRandom'");
    }

    /**
     * asd
     * 
     * @param index The position to return the value from.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void removeValueAt(int index) throws IndexOutOfBoundsException {
        if (index >= arr.length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // todo
    }

    /* public boolean isEmpty() -> already defined in SizedCollection */

    /**
     * @return If the internal array is considered full.
     */
    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    /**
     * Checks if the array has any duplicate values.
     * 
     * @return If the internal array has duplicate values.
     */
    @Override
    public boolean hasDuplicates() {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return true;
            } else {
                map.put(arr[i], 1);
            }
        }
        return false;
    }
}
