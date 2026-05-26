import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze_Print_Direction_Recursion {
    private List<String> uniquePaths(int row, int col){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, row, col);
        return res;
    }
    private void helper(List<String> res, StringBuilder sb, int row, int col){
        if(row == 1 && col == 1){
            res.add(sb.toString());
            return;
        }

        if(row > 1){
            sb.append("D");
            helper(res, sb, row - 1, col);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(col > 1){
            sb.append("R");
            helper(res, sb, row, col - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        // sb.deleteCharAt(sb.length() - 1);
        // this is wrong because we do just single time remove but it needs two times as it need times
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        Maze_Print_Direction_Recursion obj = new Maze_Print_Direction_Recursion();
        List<String> res = obj.uniquePaths(row, col);
        System.out.println(res);
        sc.close();
    }
}
