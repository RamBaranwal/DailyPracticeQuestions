import java.util.ArrayList;
import java.util.Scanner;

public class FactorOfNumber {
    // time complexity O(n)
    private void factor1(int n){
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // time complexity O(log n)
    private void factor2(int n){
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(n / i == i){
                    System.out.print(i + " ");
                }
                else{
                    System.out.print(i + " " + n / i + " ");
                }
            }
        }
        System.out.println();
    }

    // time complexity and space complexity O(log n)
    private void factor3(int n){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(n / i == i){
                    System.out.print(i + " ");
                }
                else{
                    System.out.print(i + " ");
                    res.add(n / i);
                }
            }
        }
        for(int i = res.size() - 1; i >= 0; i--){
            System.out.print(res.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        FactorOfNumber obj = new FactorOfNumber();
        obj.factor1(n);
        obj.factor2(n);
        obj.factor3(n);
        sc.close();
    }
}
