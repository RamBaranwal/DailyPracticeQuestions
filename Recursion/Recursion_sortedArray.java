import java.util.Arrays;
import java.util.Scanner;

public class Recursion_sortedArray {
    private boolean isSorted(int[] arr){
        return helper(arr, 0);
    }
    private boolean helper(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }
        return ((arr[index] < arr[index + 1]) && (helper(arr, index + 1)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Recursion_sortedArray obj = new Recursion_sortedArray();
        boolean res = obj.isSorted(arr);
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
