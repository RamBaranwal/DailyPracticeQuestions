import java.util.Scanner;

public class CombinationOFNumber {
    private int fact(int n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * fact(n - 1);
    }
    private int findMaxPaired(int n, int r){
        int total = 0;
        for(int i = 1; i <= r; i++){
            total += fact(n) / (fact(i) * fact(n - i));
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        CombinationOFNumber obj = new CombinationOFNumber();
        int res = obj.findMaxPaired(n, m);
        System.out.println(res);
        sc.close();
    }
}
