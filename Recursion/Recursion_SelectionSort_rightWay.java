import java.util.Arrays;
import java.util.Scanner;

public class Recursion_SelectionSort_rightWay {
    private int[] selectionSort(int[] arr, int row, int col, int min){
        if(row == arr.length){
            return arr;
        }
        if(col < arr.length){
            if(arr[col] < arr[min]){
                return selectionSort(arr, row, col + 1, col);
            }
            else{
                return selectionSort(arr, row, col + 1, min);
            }
        }
        else{
            int temp = arr[min];
            arr[min] = arr[row];
            arr[row] = temp;
            return selectionSort(arr, row + 1, row + 1, row + 1);
        }

    }
    private int[] sort(int[] arr){
        return selectionSort(arr, 0, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }

        Recursion_SelectionSort_rightWay obj = new Recursion_SelectionSort_rightWay();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
