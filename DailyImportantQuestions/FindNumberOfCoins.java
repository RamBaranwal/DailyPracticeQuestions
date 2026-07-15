import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class FindNumberOfCoins {
    private int findCoins(int[] money, int values){
        int count = 0;
        for(int i = 0; i < money.length; i++){
            if(values == 0){
                break;
            }
            while(values >= money[i]){
                values = values - money[i];
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split(" ");
        int[] nums = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        String str2 = br.readLine();
        int n = Integer.parseInt(str2);
        FindNumberOfCoins obj = new FindNumberOfCoins();
        int res = obj.findCoins(nums, n);
        System.out.println(res);
    }
}
