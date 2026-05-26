import java.util.Arrays;
import java.util.Scanner;

public class QUICK_SORT {
    private void quickSorting(int[] arr, int low, int high){
        int s = low;
        int e = high;
        if (low >= high) {
            return;
        }
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while(s <= e){
            while(arr[s] < pivot){
                s++;
            }
            while(arr[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }
        quickSorting(arr, low, e);
        quickSorting(arr, s, high);
    }
    private void sort(int[] arr){
        quickSorting(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        QUICK_SORT obj = new QUICK_SORT();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
