import java.util.Scanner;

public class Recursion_simple {
    // Method 1
    private static void nPrintedViceVersa(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        nPrintedViceVersa(n - 1);
        System.out.print(n + " ");
    }
    // Method 2
    private static void nPrintedViceVersa2(int n){
        if(n == 0){
            return;
        }
        System.out.print(n + " ");
        nPrintedViceVersa2(n - 1);
        if(n != 1) System.out.print(n + " ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nPrintedViceVersa(n);
        System.out.println();
        nPrintedViceVersa2(n);
        sc.close();
    }
}
