import java.util.Scanner;

public class Recursion_sum {
    private int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_sum obj = new Recursion_sum();
        System.out.println(obj.sum(n));
        sc.close();
    }
}
