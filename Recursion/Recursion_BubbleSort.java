import java.util.Arrays;
import java.util.Scanner;

public class Recursion_BubbleSort {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // here i already minus the row size by 1
    // then col < row already not reached to the last one element
    // so it is not going index out of bond
    private void bubbleSort(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                swap(arr, col, col + 1);
            }
            System.out.println(Arrays.toString(arr));
            bubbleSort(arr, row, col + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }

    private void sort(int[] res) {
        bubbleSort(res, res.length - 1, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }
        Recursion_BubbleSort obj = new Recursion_BubbleSort();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
