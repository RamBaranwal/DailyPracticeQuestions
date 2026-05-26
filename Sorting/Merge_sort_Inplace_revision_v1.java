import java.util.Arrays;
import java.util.Scanner;

public class Merge_sort_Inplace_revision_v1 {
    private void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        mergeInPlace(arr, start, mid , end);
    }
    private void mergeInPlace(int[] arr, int start, int mid, int end){
        int i = start;
        int j = mid;
        int k = 0;
        int[] mix = new int[end - start];
        while(i < mid && j < end) {
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
                k++;
            }
            else{
                mix[k] = arr[j];
                j++;
                k++;
            }
        }
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }
        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0; l < mix.length; l++){
            arr[start + l] = mix[l];
        }
    }
    private void sort(int[] arr){
        mergeSort(arr, 0, arr.length);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        Merge_sort_Inplace_revision_v1 obj = new Merge_sort_Inplace_revision_v1();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
