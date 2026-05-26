import java.util.Scanner;

public class Recursion {
    private void fun(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        fun(n - 1);
    }
    private void funRev(int n){
        if(n == 0){
            return;
        }
        funRev(n - 1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion obj = new Recursion();
        obj.fun(n);
        obj.funRev(n);
        sc.close();
    }
}