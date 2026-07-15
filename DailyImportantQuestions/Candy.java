import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Candy {
    private int[] findMinCandy(int[] arr){
        int[] candy = new int[arr.length];
        Arrays.fill(candy, 1);
        // from right to left
        for(int i = candy.length - 1; i > 0; i--){
            if(arr[i] < arr[i - 1]){
                candy[i] = candy[i] + 1;
            }
        }
        // from left to right
        for(int i = 0; i < candy.length - 1; i++){
            if(arr[i] < arr[i + 1]){
                candy[i] = candy[i] + 1;
            }
        }
        return candy;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] parts = s.split(" ");
        int[] arr = new int[parts.length];
        for(int i = 0; i < parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        Candy obj = new Candy();
        int[] res = obj.findMinCandy(arr);
        System.out.println(Arrays.toString(res));
    }
    

}
