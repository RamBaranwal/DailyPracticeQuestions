import java.util.Scanner;

public class A_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int k = sc.nextInt();
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b2 = sc.nextInt();
            int aliCount = 0;
            if(a1 > b1) aliCount++;
            if(a2 > b2) aliCount++;
            if(a1 + a2 < b1 + b2 + k){
                System.out.println("YES");
            }
            else if(a1 + a2 == k + b1 + b2){
                if(aliCount < 1){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
}