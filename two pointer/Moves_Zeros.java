import java.util.Arrays;
import java.util.Scanner;

public class Moves_Zeros {
    private void swap(int[] res, int i, int j){
        int temp = res[i];
        res[i] = res[j];
        res[j] = temp;
    }
    private void movesZero(int[] res){
        int i = 0;
        for(int j = 0; j < res.length; j++){
            if(res[j] != 0){
                swap(res, i, j);
                i++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }

        Moves_Zeros obj = new Moves_Zeros();
        obj.movesZero(res);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
