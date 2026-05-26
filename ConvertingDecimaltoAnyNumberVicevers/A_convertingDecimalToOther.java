import java.util.Scanner;

public class A_convertingDecimalToOther {
    private static int convertBinary(int n){
        return Integer.parseInt(Integer.toBinaryString(n));
    }
    private static int convertOctal(int n){
        return Integer.parseInt(Integer.toOctalString(n));
    }
    private static String convertHexa(int n){
        return Integer.toHexString(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int decimal = convertDecimal(n);
        int binary = convertBinary(n);
        int octal = convertOctal(n);
        String hexa = convertHexa(n);
        // System.out.println(decimal);
        System.out.println(binary);
        System.out.println(octal);
        System.out.println(hexa);
        sc.close();
    }
}
// this work only small if we need big then