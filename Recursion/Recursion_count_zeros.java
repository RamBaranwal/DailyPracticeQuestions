import java.util.Scanner;

public class Recursion_count_zeros {
    private int countZeros(int n){
        return helper(n, 0);
    }
    private int helper(int n, int count){
        if(n == 0){
            return count;
        }
        int rem = n % 10;
        if(rem == 0){
            return helper(n / 10, count + 1);
        }
        else{
            return helper(n / 10, count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_count_zeros obj = new Recursion_count_zeros();
        System.out.println(obj.countZeros(n));
        sc.close();
    }
}
