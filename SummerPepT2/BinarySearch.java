import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    private int findMax(int[] arr, int m){
        Arrays.sort(arr);
        int s = arr[0];
        int e = arr[arr.length - 1];
        if(m == 2){
            return e - s;
        }
        while (s < e) {
            int count = 1;
            int mid = s + (e - s) / 2;
            int i = 0;
            int j = 1;
            while (j < arr.length) {
                if(Math.abs(arr[i] - arr[j]) >= mid){
                    count++;
                    i = j;
                }
                j++;
            }
            if(count >= m){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return e;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.trim().split("\\s+");
        int[] arr = new int[strArr.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        String mStr = br.readLine();
        int m = Integer.parseInt(mStr);
        BinarySearch obj = new BinarySearch();
        int res = obj.findMax(arr, m);
        System.out.println(res);
    }
}
