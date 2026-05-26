import java.util.Scanner;

public class BinarySearch_SQRT {
    private double sqrtroot(int n, int p){
        int s = 0;
        int e = n;
        double root = 0;
        while(s <= e){
            int mid = s + (e - s) / 2;
            if(mid * mid == n){
                root = mid;
                break;
            }
            else if(mid * mid < n){
                root = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        // increase each decimal one by one
        double incre = 0.1;
        while (p > 0) {
            while (root * root <= n){
                root += incre;
            }
            root -= incre;
            p--;
            incre /= 10;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // number that we want to root
        int p = sc.nextInt();       // till place we want to root
        BinarySearch_SQRT obj = new BinarySearch_SQRT();
        double res = obj.sqrtroot(n, p);
        System.out.printf("%." +p +"f\n", res);

        System.out.printf("%." + p + "f", Math.sqrt(n));
        sc.close();
    }
}
