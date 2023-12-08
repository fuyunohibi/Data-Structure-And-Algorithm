package code;
import java.util.Arrays;

public class MyArrayBasic {
    protected int MAX_SIZE = 10;
    protected int[] data = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic(int... a) {
        for (int i = 0; i < Math.min(a.length, MAX_SIZE); i++) {
            data[i] = a[i];
            size++;
        }
    }

    public void add(int d) {
        if (size < MAX_SIZE) {
            data[size] = d;
            size++;
        }
    }

    public void insert(int d, int index) {
        if (size < MAX_SIZE && index >= 0 && index <= size) {
            for (int i = size - 1; i >= index; i--) {
                data[i + 1] = data[i];
            }
            data[index] = d;
            size++;
        } else {
            System.out.println("Cannot insert element. Invalid index or array is full.");
        }
    }

    // Method to find the index of a value in the array (either ordered or unordered)
    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    // Binary search in an ordered array. Return the index of value d in the array, else -1
    public int binarySearch(int d) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == d) {
                return mid;
            } else if (data[mid] < d) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Method to delete an element at the specified index from an ordered array
    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        } else {
            System.out.println("Cannot delete element. Invalid index.");
        }
    }

    public int getSize() {
        return size;
    }

    public int[] getArray() {
        return data;
    }

    public void setArray(int[] arr) {
        data = arr;
    }

    @Override
    public String toString() {
        return "MyArrayBasic [MAX_SIZE=" + MAX_SIZE + ", data=" + Arrays.toString(data) + ", size=" + size + "]";
    }
}
