// package b.task1;

// import java.util.Arrays;

// public class TimSort {

//     public static void main(String[] args) {
//         // Test your sorting algorithm here
//         int[] testArr = {5, 2, 9, 1, 5, 6};
//         whatSortIsThis(testArr);
//         System.out.println(Arrays.toString(testArr));  // This should print the sorted array
//     }

//     private static void whatSortIsThis(int[] arr) {
//         int BLOCK_SIZE = arr.length / 4 > 32 ? 32 : arr.length / 4;
        
//         for (int start = 0; start < arr.length; start += BLOCK_SIZE) {
//             int end = Math.min(start + BLOCK_SIZE - 1, arr.length - 1);
//             bite_size_sort(arr, start, end);
//         }

//         for (int mergeSize = BLOCK_SIZE; mergeSize < arr.length; mergeSize *= 2) {
//             for (int left = 0; left < arr.length; left += 2 * mergeSize) {
//                 int mid = left + mergeSize - 1;
//                 int right = Math.min(left + 2*mergeSize - 1, arr.length - 1);
                
//                 if (mid < right) 
//                     merge(arr, left, mid, right);
//             }
//         }
//     }

//     private static void bite_size_sort(int[] b, int start, int end) {
//         for (int i = start; i <= end; i++) {
//             int j = i;
//             int tmp = b[j];
            
//             while (j > start && b[j - 1] > tmp) {
//                 b[j] = b[j-1];
//                 j--;
//             }
            
//             b[j] = tmp;
//         }
//     }

//     private static void merge(int[] twob, int low, int mid, int high) {
//         int[] leftArr = new int[mid - low + 1];
//         int[] rightArr = new int[high - mid];

//         System.arraycopy(twob, low, leftArr, 0, leftArr.length);
//         System.arraycopy(twob, mid + 1, rightArr, 0, rightArr.length);

//         int leftCounter = 0;
//         int rightCounter = 0;
//         int twobCounter = low;

//         while (leftCounter < leftArr.length && rightCounter < rightArr.length) {
//             twob[twobCounter++] = leftArr[leftCounter] < rightArr[rightCounter] 
//                                   ? leftArr[leftCounter++] 
//                                   : rightArr[rightCounter++];
//         }
        
//         while (leftCounter < leftArr.length) {
//             twob[twobCounter++] = leftArr[leftCounter++];
//         }
        
//         while (rightCounter < rightArr.length) {
//             twob[twobCounter++] = rightArr[rightCounter++];
//         }
//     }
// }


private static void whatSortIsThis(int[] arr) {
    int BLOCK_SIZE = arr.length / 4 > 32 ? 32 : arr.length / 4;
    for (int start = 0; start < arr.length; start += BLOCK_SIZE) {
        int end = Math.min(start + BLOCK_SIZE - 1, arr.length - 1);
        bite_size_sort(arr, start, end);
    }
    // ============ LAB_8b_65011338 MY CODE 1 ============
    for (int mergeSize = BLOCK_SIZE; mergeSize < arr.length; mergeSize *= 2) {
        for (int left = 0; left < arr.length; left += 2 * mergeSize) {
            int mid = left + mergeSize - 1;
            int right = Math.min(left + 2 * mergeSize - 1, arr.length - 1);
            if (mid < right) {
                merge(arr, left, mid, right);
            }
        }
    }
    System.out.println(Arrays.toString(arr));
}

// ============ LAB_8b_65011338 MY CODE 2 ============
private static void bite_size_sort(int[] b, int start, int end) {
    for (int i = start; i <= end; i++) {
        int j = i;
        int tmp = b[j];
        while (j > start && b[j - 1] > tmp) {
            b[j] = b[j - 1];
            j--;
        }
        b[j] = tmp;
    }
}

private static void merge(int[] twob, int low, int mid, int high) {
    int[] leftArr = new int[mid - low + 1];
    int[] rightArr = new int[high - mid];
    System.arraycopy(twob, low, leftArr, 0, leftArr.length);
    System.arraycopy(twob, mid + 1, rightArr, 0, rightArr.length);
    int leftCounter = 0;
    int rightCounter = 0;
    int twobCounter = low;

    while (leftCounter < leftArr.length && rightCounter < rightArr.length) {
        // ============ LAB_8b_65011338 MY CODE 3 ============
        twob[twobCounter++] = leftArr[leftCounter] < rightArr[rightCounter]
            ? leftArr[leftCounter++] 
            : rightArr[rightCounter++];
    }
    while (leftCounter < leftArr.length) {
        twob[twobCounter++] = leftArr[leftCounter++];
    }
    while (rightCounter < rightArr.length) {
        twob[twobCounter++] = rightArr[rightCounter++];
    }
}

