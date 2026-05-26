import java.util.Arrays;
import java.util.Scanner;

public class Selection_sort_rightWaySorting {
    private int minElement(int[] arr, int start){
        int min = start;
        for(int i = start; i < arr.length;i++){
            if(arr[i] < arr[min]){
                min = i;
            }
        }
        return min;
    }
    private void swap(int[] arr, int i, int minElementIndex){
        int temp = arr[i];
        arr[i] = arr[minElementIndex];
        arr[minElementIndex] = temp;
    }
    private int[] selectionSorting(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int minElementIndex = minElement(arr, i);
            swap(arr, i, minElementIndex);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        Selection_sort_rightWaySorting obj = new Selection_sort_rightWaySorting();
        System.out.println(Arrays.toString(obj.selectionSorting(res)));
        sc.close();
    }
}
