import java.util.Arrays;
import java.util.Scanner;

public class Quick_sorting_reveision_v1 {
    private void sort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }
    private void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
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
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        Quick_sorting_reveision_v1 obj = new Quick_sorting_reveision_v1();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
