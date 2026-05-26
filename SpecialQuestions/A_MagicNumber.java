import java.util.Scanner;

public class A_MagicNumber {
    private static long nMagicNumber(int n){
        long magic = 0;
        long pow = 5;
        long MOD = 1000000007;
        while(n > 0){
            int last = n & 1;
            if(last == 1){
                magic = (magic + pow) % MOD;
            }
            pow = (pow * 5) % MOD;
            n = n >> 1;
        }
        return magic;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = nMagicNumber(n);
        System.out.println(res);
        sc.close();
    }
}
