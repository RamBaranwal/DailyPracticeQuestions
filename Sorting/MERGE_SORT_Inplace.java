import java.util.Arrays;
import java.util.Scanner;

public class MERGE_SORT_Inplace {
    private void sort(int[] arr){
        mergeSort(arr, 0, arr.length);
    }
    private void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }
    private void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while(i < mid && j < end){
            if(arr[i] > arr[j]){
                mix[k] = arr[j];
                k++;
                j++;
            }
            else{
                mix[k] = arr[i];
                i++;
                k++;
            }
        }
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < end) {
            mix[k] = arr[j];
            k++;
            j++;
        }

        for(int l = 0; l < mix.length; l++){
            arr[start + l] = mix[l];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        MERGE_SORT_Inplace obj = new MERGE_SORT_Inplace();
        obj.sort(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
    
}
