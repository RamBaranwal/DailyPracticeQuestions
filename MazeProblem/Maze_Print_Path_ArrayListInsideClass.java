import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze_Print_Path_ArrayListInsideClass {
    private List<String> uniquePaths(int row, int col){
        StringBuilder sb = new StringBuilder();
        return helper(sb, row, col);
    }
    private List<String> helper(StringBuilder sb, int row, int col){
        if(row  == 1 && col == 1){
            ArrayList<String> res = new ArrayList<>();
            res.add(sb.toString());
            return res;
        }

        ArrayList<String> res = new ArrayList<>();
        if(row > 1){
            sb.append("D");
            res.addAll(helper(sb, row - 1, col));
            sb.deleteCharAt(sb.length() - 1);
        }

        if(col > 1){
            sb.append("R");
            res.addAll(helper(sb, row, col - 1));
            sb.deleteCharAt(sb.length() - 1);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        Maze_Print_Path_ArrayListInsideClass obj = new Maze_Print_Path_ArrayListInsideClass();
        List<String> res = obj.uniquePaths(row, col);
        System.out.println(res);
        sc.close();
    }
}
