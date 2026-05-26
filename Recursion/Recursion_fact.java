import java.util.Scanner;

public class Recursion_fact {
    private int fact(int n){
        if(n == 1){
            return 1;
        }
        return n * fact(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_fact obj = new Recursion_fact();
        int res = obj.fact(n);
        System.out.println(res);
        sc.close();
    }
}
