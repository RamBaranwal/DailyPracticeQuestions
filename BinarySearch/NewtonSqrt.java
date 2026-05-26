import java.util.Scanner;

public class NewtonSqrt {
    // formula
    // root = (x + (n/x))/2
    // this is the formula to get the square root x is the assumption
    // to get minimum error we do |root - x| < 1 or 0.5 < 0.01 as the precision required
    private double byNewtonMethod(int n){
        double x = n;
        double root = 0;
        while(true){
            root = 0.5 * (x + (n / x));
            if(Math.abs(root - x) < 0.01){
                break;
            }
            x = root;
            System.out.println(root);
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NewtonSqrt obj = new NewtonSqrt();
        double res = obj.byNewtonMethod(n);
        System.out.println(res);
        sc.close();
    }
}
