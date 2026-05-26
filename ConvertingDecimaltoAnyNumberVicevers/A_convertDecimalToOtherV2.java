import java.util.Scanner;

public class A_convertDecimalToOtherV2 {
    private static String convertBinary(int n) {
        return (Integer.toBinaryString(n));
    }

    private static String convertOctal(int n) {
        return (Integer.toOctalString(n));
    }

    private static String convertHexa(int n) {
        return Integer.toHexString(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int decimal = convertDecimal(n);
        String binary = convertBinary(n);
        String octal = convertOctal(n);
        String hexa = convertHexa(n);
        // System.out.println(decimal);
        System.out.println(binary);
        System.out.println(octal);
        System.out.println(hexa);
        sc.close();
    }
}
