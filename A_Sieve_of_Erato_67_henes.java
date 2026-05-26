import java.util.Scanner;

public class A_Sieve_of_Erato_67_henes {
    // key point is that here not need of 1 alone 67 is enough to have it passed
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            boolean has67 = false;
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                if(x == 67) has67 = true;
            }
            if(has67){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            t--;
        }
        sc.close();
    }
}