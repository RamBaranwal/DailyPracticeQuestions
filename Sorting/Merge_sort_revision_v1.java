import java.util.Arrays;
import java.util.Scanner;

public class Merge_sort_revision_v1 {
    private int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = (arr.length) / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return mergeInPlace(left, right);
    }
    private int[] mergeInPlace(int[] first, int[] second){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] mix = new int[first.length + second.length];
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
                k++;
            }
            else{
                mix[k] = second[j];
                k++;
                j++;
            }
        }
        while (i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        Merge_sort_revision_v1 obj = new Merge_sort_revision_v1();
        System.out.println(Arrays.toString(obj.mergeSort(res)));
        sc.close();
    }
}
