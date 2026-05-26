import java.util.Scanner;

public class Recursion_reverseNumber {
    private int printReverse(int n ){
        return printReverse(0, n);
    }
    private int printReverse(int r, int n){
        if(n == 0){
            return r;
        }
        return printReverse(r * 10 + (n % 10), n / 10);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_reverseNumber obj = new Recursion_reverseNumber();
        int res = obj.printReverse(n);
        System.out.println(res);
        sc.close();
    }
}
