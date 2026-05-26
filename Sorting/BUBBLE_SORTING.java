import java.util.Arrays;
import java.util.Scanner;

public class BUBBLE_SORTING {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int[] bubbleSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        BUBBLE_SORTING obj = new BUBBLE_SORTING();

        long start = System.nanoTime();
        // System.out.println(start);

        int[] sortedArray = obj.bubbleSorting(arr);

        long end = System.nanoTime();
        // System.out.println(end);

        long executionTime = end - start;

        System.out.println(Arrays.toString(sortedArray));

        System.out.println("Execution Time: " + executionTime + " ns");

        sc.close();
    }
}
