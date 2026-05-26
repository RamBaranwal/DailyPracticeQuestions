import java.util.Scanner;

public class Recursion_BinarySearch_findTarget {
    private int findTarget(int[] arr, int target){
        return binarySearch(arr, target, 0, arr.length - 1);
    }
    private int binarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if(arr[start] <= arr[mid]){
            if(target >= arr[start] && target < arr[mid]){
                return binarySearch(arr, target, start, mid - 1);
            }
            else{
                return binarySearch(arr, target, mid + 1, end);
            }
        }
        else{
            if(target > arr[mid] && target <= arr[end]){
                return binarySearch(arr, target, mid + 1, end);
            }
            else{
                return binarySearch(arr, target, start, mid - 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Recursion_BinarySearch_findTarget obj = new Recursion_BinarySearch_findTarget();
        System.out.println(obj.findTarget(res, target));
        sc.close();
    }
}
