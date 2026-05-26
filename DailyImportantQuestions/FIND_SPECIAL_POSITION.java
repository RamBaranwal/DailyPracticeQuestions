// import java.util.ArrayList;
import java.util.Scanner;

public class FIND_SPECIAL_POSITION {

    // private boolean onesSameRowColumn(ArrayList<ArrayList<Integer>> result) {
    //     int n = result.size();
    //     int m = result.get(0).size();

    //     // comparing column wise
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m - 1; j++) {
    //             if (result.get(i).get(j) == result.get(i).get(j + 1)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     // comparing row wise
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n - 1; j++) {
    //             if (result.get(j).get(i) == result.get(j).get(j + 1)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    private boolean specialPosition(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n = number of rows
        // m = number of columns
        // always take input be 0 or 1
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        FIND_SPECIAL_POSITION obj = new FIND_SPECIAL_POSITION();
        boolean special = obj.specialPosition(arr);
        System.out.println(special);
        sc.close();
    }
}