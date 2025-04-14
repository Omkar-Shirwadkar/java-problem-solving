import java.util.Arrays;

public class AllTogetherSort{
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap array[i] and array[minIndex]
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
    public static void countingSort(int[] array) {
        int maxEle = Arrays.stream(array).max().getAsInt();
        int minEle = Arrays.stream(array).min().getAsInt();
        int range = maxEle - minEle + 1;
        int[] count = new int[range];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minEle]++;
        }
        int j = 0;
        int i = 0;
        while (j < array.length) {
            if (count[i] > 0) {
                array[j] = i + minEle;
                count[i]--;
                j++;
            }
            else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, -100, 8, 8, 89, 9, 9, 9};
        System.out.println("Original Array: " + Arrays.toString(arr));
        // bubbleSort(arr);
        // System.out.println("Bubble Sorted: " + Arrays.toString(arr));
        // selectionSort(arr);
        // System.out.println("Selection Sorted: " + Arrays.toString(arr));
        // insertionSort(arr);
        // System.out.println("Insertion Sorted: " + Arrays.toString(arr));
        countingSort(arr);
        System.out.println("Counting Sorted: " + Arrays.toString(arr));
    }
}