import java.util.Arrays;
import java.util.Scanner;

public class SELECTION_SORTING {
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    private int getMaxIndex(int[] arr, int start, int last){
        int max = start;
        for(int i = 0; i <= last; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;
    }
    private int[] selectionSorting(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int last = arr.length - 1 - i;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last);
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        SELECTION_SORTING obj = new SELECTION_SORTING();
        int[] sortedArray = obj.selectionSorting(arr);
        System.out.println(Arrays.toString(sortedArray));
        sc.close();
    }
}
