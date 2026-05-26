import java.util.Scanner;

public class Recursion_opposite_number {
    int sum = 0;
    private void reverseNumber1(int n){
        if(n == 0){
            return;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseNumber1(n / 10);
    }

    private int reverseNumber2(int n){
        int digit = (int)(Math.log10(n) + 1);
        return helper(n, digit);
    }

    private int helper(int n, int digit){
        if(n % 10 == n){
            return n;
        }
        int rem = n % 10;
        return (rem * (int)(Math.pow(10, digit - 1)) + helper(n / 10, digit - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_opposite_number obj = new Recursion_opposite_number();
        obj.reverseNumber1(n);
        System.out.println(obj.sum);
        System.out.println(obj.reverseNumber2(n));
        sc.close();
    }
}
