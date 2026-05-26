import java.util.Scanner;

public class GCD {
    private int findGCDeasyMethod(int a, int b){
        if(a == 0){
            return b;
        }
        return findGCDeasyMethod(a % b, a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        GCD obj = new GCD();
        System.out.println(obj.findGCDeasyMethod(a, b));
        sc.close();
    }
}
