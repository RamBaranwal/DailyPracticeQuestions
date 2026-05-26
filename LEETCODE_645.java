import java.util.Arrays;
import java.util.Scanner;

public class LEETCODE_645 {
    private int[] setMisMatch(int[] nums){
        int n = nums.length;
        int[] newNums = new int[n + 1];
        for(int i = 1; i <= n; i++){
            newNums[i] = i;
        }
        int j = 1;
        for(int i = 0; i < n; i++){
            if(nums[i] != newNums[j]){
                
            }
            j++;
        }
        return newNums;
        // for(int i = 0;)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            LEETCODE_645 obj = new LEETCODE_645();
            int[] result = obj.setMisMatch(arr);
            System.out.println(Arrays.toString(result));
        }
        sc.close();
    }
}
