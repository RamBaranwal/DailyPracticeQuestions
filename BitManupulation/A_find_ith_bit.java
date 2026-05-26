import java.util.Scanner;

public class A_find_ith_bit {
    private static int findIthBit(String n, int i){
        int num = Integer.parseInt(n, 2);
        return (num & (1 << (i - 1))) != 0 ? 1 : 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int i = sc.nextInt();
        int ithbit = findIthBit(n, i);
        int num = Integer.parseInt(n, 2);
        System.out.println(num);
        System.out.println(ithbit);
        sc.close();
    }
}
