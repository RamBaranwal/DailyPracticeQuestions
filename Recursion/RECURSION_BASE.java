import java.util.Scanner;

public class RECURSION_BASE {
    // private static void countingTill(int n) {
    //     if (n == 0)
    //         return;
    //     System.out.print(n + " ");
    //     countingTill(n - 1);
    // }

    public static int fibo(int n){
        if(n < 2){
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // countingTill(n);
        System.out.println(fibo(n));
        sc.close();
    }
}
