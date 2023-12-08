package b.task1;

import java.util.Arrays;

public class BlockSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 3, 7, 6, 8, 2, 4, 0};
        int blockSize = 2;
        blockSort(arr, blockSize);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void blockSort(int[] arr, int blockSize) {
      int n = arr.length;

      // Split into blocks and sort each block
      for (int i = 0; i < n; i += blockSize) {
        int end = Math.min(i + blockSize, n);
        Arrays.sort(arr, i, end);
      }

      // Merge blocks
      while (blockSize < n / 2) {
        for (int i = 0; i < n; i += 2 * blockSize) {
          int mid = i + blockSize;
          int end = Math.min(i + 2 * blockSize, n);
          merge(arr, i, mid, end);
        }
        blockSize *= 2;
      }

      // Final merge of the larger blocks
      merge(arr, 0, blockSize, n); // Add this line here.
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start];
        int i = start, j = mid, k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i < mid && i < arr.length) { // Adjusted here
            temp[k++] = arr[i++];
        }
        
        while (j < end && j < arr.length) { // Adjusted here
            temp[k++] = arr[j++];
        }
        
        for (i = start, k = 0; i < end; i++, k++) {
            arr[i] = temp[k];
        }
    }

    
}
