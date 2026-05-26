import java.util.ArrayList;
import java.util.Scanner;

public class FIND_SPC_POS {
    private int onesSameRowColumn(ArrayList<ArrayList<Integer>> result) {
        int n = result.size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int r1 = result.get(i).get(0);
            int c1 = result.get(i).get(1);
            boolean special = true;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                int r2 = result.get(j).get(0);
                int c2 = result.get(j).get(1);

                if (r1 == r2 || c1 == c2) {
                    special = false;
                    break;
                }
            }

            if (special)
                count++;
        }

        return count;
    }

    private int specialPosition(int[][] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    ArrayList<Integer> tru = new ArrayList<>();
                    tru.add(i);
                    tru.add(j);
                    res.add(tru);
                }
            }
        }
        // calling which is 1 in same row or column or not
        int count = onesSameRowColumn(res);
        return count;

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
        FIND_SPC_POS obj = new FIND_SPC_POS();
        int special = obj.specialPosition(arr);
        System.out.println(special);
        sc.close();
    }
}