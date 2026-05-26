import java.util.Scanner;

public class TEAM {
    private int findHowManySolved(int[][] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            int eachCount = 0;
            for(int j = 0; j < 3; j++){
                if(arr[i][j] == 1){
                    eachCount++;
                }
            }
            if(eachCount >= 2) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] sol = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                sol[i][j] = sc.nextInt();
            }
        }

        TEAM obj = new TEAM();
        int res = obj.findHowManySolved(sol);
        System.out.println(res);
        sc.close();
    }
}
