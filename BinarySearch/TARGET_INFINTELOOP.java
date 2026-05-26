import java.util.Scanner;

public class TARGET_INFINTELOOP {
    private int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int findFromUnknownArray(int[] nums, int target) {
        int start = 0;
        int end = 1;

        // find the array length which have target value we increase box length it by
        // exponential
        while (nums[end] < target) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        int index = binarySearch(nums, target, start, end);
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        TARGET_INFINTELOOP obj = new TARGET_INFINTELOOP();
        int index = obj.findFromUnknownArray(arr, k);
        System.out.println(index);
        sc.close();
    }
}