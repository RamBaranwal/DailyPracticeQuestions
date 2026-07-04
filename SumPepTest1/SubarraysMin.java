// package SumPepTest1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SubarraysMin {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();

        String[] input = st.split(" ");
        int[] num = new int[input.length];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(input[i]);
        }
        
        SubarraysMin obj = new SubarraysMin();
        int res = obj.minSubArraysSum(num);
        System.out.println(res);
    }

    private int minSubArraysSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }
}
