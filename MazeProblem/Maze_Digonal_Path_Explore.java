import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze_Digonal_Path_Explore {
    private List<String> uniquePaths(int row, int col){
        List<String> res = new ArrayList<>();
        helper(res, "", row, col);
        return res;
    }
    private void helper(List<String> res,String p, int row, int col){
        if(row == 1 && col == 1){
            res.add(p);
            return;
        }

        if(row > 1 && col > 1){
            helper(res, p + "H", row - 1, col - 1);
        }

        if(row > 1){
            helper(res, p + "D", row - 1, col);
        }

        if(col > 1){
            helper(res, p + "R", row, col - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        Maze_Digonal_Path_Explore obj = new Maze_Digonal_Path_Explore();
        List<String> res = obj.uniquePaths(row, col);
        System.out.println(res);
        sc.close();
    }
}
