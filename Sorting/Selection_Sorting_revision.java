import java.util.Arrays;
import java.util.Scanner;

public class Selection_Sorting_revision {
    private void swap(int[] arr, int maxElementAtLastIndex,int last){
        int temp = arr[maxElementAtLastIndex];
        arr[maxElementAtLastIndex] = arr[last];
        arr[last] = temp;
    }

    private int maxElement(int[] arr, int last){
        int maxIndex = 0;
        for(int i = 0; i <= last; i++){
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    private int[] selectionSorting(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int last = arr.length - 1 - i;
            int maxElementAtLastIndex = maxElement(arr, last);
            swap(arr, maxElementAtLastIndex, last);
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
        Selection_Sorting_revision obj = new Selection_Sorting_revision();
        System.out.println(Arrays.toString(obj.selectionSorting(res)));
        sc.close();
    }
}
