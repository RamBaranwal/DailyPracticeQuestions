import java.util.Scanner;

public class Recursion_factorial {
    private int recursion(int n){
    if(n == 0){
        return 1;
    }
    int fact = recursion(n - 1);
    fact = fact * n;
    System.out.println(n + "! = " + fact);
    return fact;
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_factorial obj = new Recursion_factorial();
        obj.recursion(n);
        // System.out.println(res);
        sc.close();
    }
}
