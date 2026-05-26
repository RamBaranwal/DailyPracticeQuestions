import java.util.Arrays;
import java.util.Scanner;

public class RECURSION_BINARY_SEARCH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Arrays.sort(arr);
        RECURSION_BINARY_SEARCH obj = new RECURSION_BINARY_SEARCH();
        int res = obj.binarySearch(arr, target, 0, arr.length - 1);
        System.out.print(res);
        sc.close();
    }

    private int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            // it is used to find first occurrence for same last occurrence
            // we can move right side doing mid + 1 for start
            int left = binarySearch(arr, target, start, mid - 1);
            if (left != -1) {
                return left;
            }
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, end);
    }
}
