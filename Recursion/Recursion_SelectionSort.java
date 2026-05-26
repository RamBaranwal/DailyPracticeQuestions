import java.util.Arrays;
import java.util.Scanner;

public class Recursion_SelectionSort {
    private int[] selectionSort(int[] arr, int row, int col, int max){
        if(row == 0){
            return arr;
        }
        if(row > col){
            if(arr[max] < arr[col]){
                System.out.println(Arrays.toString(arr));
                return selectionSort(arr, row, col + 1, col);
            }
            else{
                System.out.println(Arrays.toString(arr));
                return selectionSort(arr, row, col + 1, max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            return selectionSort(arr, row - 1, 0, 0);
        }
    }

    private int[] sort(int[] arr){
        return selectionSort(arr, arr.length, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        Recursion_SelectionSort obj = new Recursion_SelectionSort();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
