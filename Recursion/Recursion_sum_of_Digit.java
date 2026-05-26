import java.util.Scanner;

public class Recursion_sum_of_Digit {
    private int findSumOfDigit(int n){
        if(n <= 0){
            return 0;
        }
        return (n % 10) + (findSumOfDigit(n / 10));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_sum_of_Digit obj = new Recursion_sum_of_Digit();
        System.out.println(obj.findSumOfDigit(n));
        sc.close();
    }
}
