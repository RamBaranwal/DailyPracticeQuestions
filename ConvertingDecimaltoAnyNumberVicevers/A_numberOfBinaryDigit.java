import java.util.Scanner;

public class A_numberOfBinaryDigit {
    private static int binaryDigitNumber(int n){
        int base = 2;
        return (int)(Math.log(n)/ Math.log(base)) + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = binaryDigitNumber(n);
        System.out.println(res);
        sc.close();
    }
}