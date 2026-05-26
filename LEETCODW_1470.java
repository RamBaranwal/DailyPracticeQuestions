// import java.util.Arrays;
import java.util.Scanner;

public class LEETCODW_1470 {
    private int[] suffleArray(int[] nums, int n) {
        int[] newNums = new int[2 * n];
        int j = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            newNums[i] = nums[j];
            newNums[i + 1] = nums[n + j];
            j++;
        }
        return newNums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            int m = sc.nextInt(); // element into array
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            int n = sc.nextInt(); // half of array

            LEETCODW_1470 obj = new LEETCODW_1470();
            obj.suffleArray(arr, n);
            // System.out.print(Arrays.toString(result));
            // for(int i : result){
            // System.out.print(i);
            // }
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i != arr.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        sc.close();
    }
}
