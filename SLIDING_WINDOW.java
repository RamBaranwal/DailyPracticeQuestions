// import java.util.ArrayList;
import java.util.Scanner;

public class SLIDING_WINDOW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while(testCase-- > 0){
            int n = sc.nextInt();
            
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            int target = sc.nextInt();

            SLIDING_WINDOW obj = new SLIDING_WINDOW();
            int result = obj.largestLength(arr, target);
            System.out.println(result);
        }
        sc.close();
    }

    public int largestLength(int nums[], int k){
        int r = 0;
        int l = 0;
        int sum = 0;
        int maxLen = 0;
        int startIndex = -1;
        int endIndex = -1;
        while(r < nums.length){
            sum += nums[r];
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            if(sum <= k){
                if(maxLen < r - l + 1){
                    maxLen = r - l + 1;
                    startIndex = l;
                    endIndex = r;
                }
            }
            r++;
        }
        if(startIndex != -1){
            System.out.print("Subarray: ");
            for(int i = startIndex; i <= endIndex; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
        return maxLen;
        
    }
}
