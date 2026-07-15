import java.io.*;

/**
 * ClimbingStairs1and2
 */
public class ClimbingStairs1and2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        ClimbingStairs1and2 obj = new ClimbingStairs1and2();
        int res = obj.climbStairs(n);
        System.out.println(res);
    }

    private int climbStairs(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
