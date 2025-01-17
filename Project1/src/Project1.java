import java.util.Arrays;

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
    private int capacity;
    private int size;

    public Project1(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public int[] getArray() {
        return this.arr;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

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

    public int getAverage() throws IllegalStateException {
        if (arr.length == 0) {
            throw new IllegalStateException();
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result /= size();
    }

    public int getRange() {
        return this.getMaximum() - this.getMinimum();
    }

    public int getMode() { // todo
        return Integer.MAX_VALUE;
    }

    public int getMedian() {
        int[] arrSorted = Arrays.copyOf(arr, arr.length);
        if (arrSorted.length % 2 == 0) {
            // todo
        } else {
            return arrSorted[arrSorted.length / 2 + 1]; // todo - needs to be tested
        }
        return -1; // temp
    }

    // returns the number of elements stored in the array.
    @Override
    public int size() {
        return this.getSize();
    }

    // returns the size of the array, that is how big the array is, not how many
    // elements are stored in it.
    public int capacity() {
        return this.getCapacity();
    }

    @Override
    public void addValue(int value) throws IllegalStateException {
        this.size++;

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addValue'");
    }

    @Override
    public int getValue(int index) throws IndexOutOfBoundsException {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public int setValue(int index, int value) throws IndexOutOfBoundsException {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        }

        int result = arr[index];
        arr[index] = value;
        return result;
    }

    @Override
    public void addRandom(int n) throws IllegalStateException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addRandom'");
    }

    @Override
    public void removeValueAt(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeValueAt'");
    }

    /* public boolean isEmpty() -> already defined in SizedCollection */

    @Override
    public boolean isFull() {
        return size() == capacity();
    }

    @Override
    public boolean hasDuplicates() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasDuplicates'");
    }
}
