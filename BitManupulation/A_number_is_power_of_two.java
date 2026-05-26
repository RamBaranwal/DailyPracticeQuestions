import java.util.Scanner;

public class A_number_is_power_of_two {
    // logic here
    // if n = power of it like 100000 at starting 1 and rest 0
    // and for n == power of 2 we have 11111 + 1 (1... it is lest then 1 place two n)
    // and 11111 is n - 1 so
    //   1 0 0 0 0 0 0
    // & 0 1 1 1 1 1 1
    // ----------------
    //   0 0 0 0 0 0 0
    // so at end if it is power of the & make it 0 other wise some random value come
    private boolean isPowerOfTwo(int n){
        return ((n & (n - 1)) == 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            A_number_is_power_of_two obj = new A_number_is_power_of_two();
            boolean res = obj.isPowerOfTwo(n);
            System.out.println(res);
        }
        sc.close();
    }
}
