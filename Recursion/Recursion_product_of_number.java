import java.util.Scanner;

public class Recursion_product_of_number {
    private int productOfNumber(int n){
        if(n % 10 == n){
            return n;
        }
        return (n % 10) * (productOfNumber(n / 10));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_product_of_number obj = new Recursion_product_of_number();
        System.out.println(obj.productOfNumber(n));
        sc.close();
    }
}
