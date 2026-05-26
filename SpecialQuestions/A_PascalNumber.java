import java.util.Scanner;

public class A_PascalNumber {
    private void pascalTree(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }
            int num = 1;
            for(int j = 0; j <= i; j++){
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
    // sum of each row of pascal tree is equal to the 2^(n-1)
    private int rowSum(int n) {
        return 1 << n;   // 2^n
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        A_PascalNumber obj = new A_PascalNumber();
        obj.pascalTree(n);
        System.out.println("\nSum of last row = " + obj.rowSum(n - 1));
        sc.close();
    }
}
