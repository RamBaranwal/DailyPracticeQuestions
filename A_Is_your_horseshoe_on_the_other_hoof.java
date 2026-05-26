import java.util.Arrays;
import java.util.Scanner;

public class A_Is_your_horseshoe_on_the_other_hoof {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] color = new int[4];
        for(int i = 0; i < 4; i++){
            color[i] = sc.nextInt();
        }
        int count = 0;
        Arrays.sort(color);
        for(int i = 1; i < 4; i++){
            if(color[i] == color[i - 1]){
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}