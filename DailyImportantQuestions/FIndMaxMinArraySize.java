import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FIndMaxMinArraySize {
    private int findMaxLength(int[] arr, int k){
        int maxSize = 0;
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(right < arr.length){
            if(arr[right] - arr[left] <= k){
                res.add(arr[right]);
                maxSize = Math.max(maxSize, right - left + 1);
                right++;
            }
            else{
                res.remove(left);
                left++;
            }
        }
        System.out.println(res);
        return maxSize;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(" ");
        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        String str2 = br.readLine();
        int n = Integer.parseInt(str2);
        FIndMaxMinArraySize obj = new FIndMaxMinArraySize();
        int res = obj.findMaxLength(nums, n);
        System.out.println(res);
    }
}
