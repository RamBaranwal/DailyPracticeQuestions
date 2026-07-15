import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStairs12And3 {
    private int climbStairs(int n){
        if(n == 2) return 2;
        if(n == 1) return 1;
        if(n == 0) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        ClimbingStairs12And3 obj = new ClimbingStairs12And3();
        int res = obj.climbStairs(n);
        System.out.println(res);
    }
}
