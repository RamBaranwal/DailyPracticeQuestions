import java.util.Arrays;
import java.util.Scanner;

public class CYCLIC_SORTING {
    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private int[] cyclicSort(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
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

        CYCLIC_SORTING obj = new CYCLIC_SORTING();
        int[] sortedArray = obj.cyclicSort(arr);
        System.out.println(Arrays.toString(sortedArray));
        sc.close();
    }
}
