import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze_Print_Path_Recursion {
    private List<String> uniquePaths(int row, int col){
        List<String> res = new ArrayList<>();
        helper(res, "", 0, 0, row - 1, col - 1);
        return res;
    }
    private void helper(List<String> res, String p, int crow, int ccol, int row, int col){
        if(crow == row && ccol == col){
            res.add(p);
            return;
        }
        if(crow < row){
            helper(res, p + "D", crow + 1, ccol, row, col);
        }
        if(ccol < col){
            helper(res, p + "R", crow, ccol + 1, row, col);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        Maze_Print_Path_Recursion obj = new Maze_Print_Path_Recursion();
        List<String> res = obj.uniquePaths(row, col);
        System.out.println(res);
        sc.close();
    }
}
