import java.util.Arrays;
import java.util.Scanner;

public class MERGE_SORT {
    private int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        // System.out.println(Arrays.toString(left) + "l..");
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        // System.out.println(Arrays.toString(right) + "r..");

        return merge(left, right);
    }
    private int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];
        // System.out.println(Arrays.toString(mix) + "m..");
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
                k++;
            }
            else{
                mix[k] = second[j];
                j++;
                k++;
            }
        }
        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        // System.out.println(Arrays.toString(first) + "f..");
        // System.out.println(Arrays.toString(second) + "s..");
        return mix;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        MERGE_SORT obj = new MERGE_SORT();
        int[] arr = obj.mergeSort(res);
        int[] ans = res;
        System.out.println(Arrays.toString(arr)); // it is new obj created copied all the values of the array
        System.out.println(Arrays.toString(ans)); // the main array not changed
        sc.close();
    }
}
