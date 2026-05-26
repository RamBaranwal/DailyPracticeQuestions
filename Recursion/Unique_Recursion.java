import java.util.Scanner;

public class Unique_Recursion {
    public static int uniquePaths(int m, int n) {
        return helper(0, 0, m - 1, n - 1);
    }
    private static int helper(int cc, int cr, int lc, int lr){
        if(cr > lr || cc > lc){
            return 0;
        }
        if(cc == lc && cr == lr){
            return 1;
        }
        int right = helper(cc + 1, cr, lc, lr);
        int down = helper(cc, cr + 1, lc, lr);
        return right + down;
    }
    public static int uniquePaths2(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = uniquePaths(m, n);
        int count2 = uniquePaths2(m, n);
        System.out.println(count);
        System.out.println(count2);
        sc.close();
    }
}
