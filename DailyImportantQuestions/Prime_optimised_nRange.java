import java.util.Scanner;

public class Prime_optimised_nRange {
    private void sieve(int n, boolean[] primes){
        for(int i = 2; i * i <= n; i++){
            if(!primes[i]){
                for(int j = i * 2; j <= n; j += i){
                    primes[j] = true;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] primes = new boolean[n + 1];
        Prime_optimised_nRange obj = new Prime_optimised_nRange();
        obj.sieve(n, primes);
        sc.close();
    }
}
