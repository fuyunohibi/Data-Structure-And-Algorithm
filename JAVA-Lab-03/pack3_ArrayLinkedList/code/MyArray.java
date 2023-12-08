package code;
import java.util.Arrays;

public class MyArray extends MyArrayBasic {
    private static final int DEFAULT_MAX_SIZE = 100_000;
    private int maxSize;

    public MyArray() {
        this(DEFAULT_MAX_SIZE); // Constructor / Default max size
    }

    public MyArray(int max) { // Constructor / Custom max size
        super(max); 
        this.maxSize = max;
    }

    public boolean isFull() {
        return getSize() >= maxSize;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int[] expandByK(int k) {
        int newCapacity = getSize() + (k * maxSize);
        int[] newArr = new int[newCapacity];

        /* copy src array to dest array, begin from index 0, 
           create new array with increased capacity, 
           start from index 0 in new array, return size of new array */
        System.arraycopy(getArray(), 0, newArr, 0, getSize());  
        setArray(newArr);
        return newArr;
    }

    public int[] expand() {
        return expandByK(2);
    }

    @Override 
    public void add(int d) {
       if (isFull()) {
             System.out.println("Array is full. Expanding array...");
             expand();
       }
       super.add(d);
    }

}

