import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Maze_Obstacles_Print_Path_Recursion {
    private List<String> uniquePaths(int[][] obstacles) {
        return helper("", 0, 0, obstacles);
    }

    private List<String> helper(String p, int row, int col, int[][] obstacles) {
        if (row == obstacles.length - 1 && col == obstacles[0].length - 1) {
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> res = new ArrayList<>();
        if (obstacles[row][col] == 1) {
            return new ArrayList<>();
        }

        if (row < obstacles.length - 1) {
            res.addAll(helper(p + "D", row + 1, col, obstacles));
        }
        if (col < obstacles[0].length - 1) {
            res.addAll(helper(p + "R", row, col + 1, obstacles));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] obstacles = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                obstacles[i][j] = sc.nextInt();
            }
        }
        Maze_Obstacles_Print_Path_Recursion obj = new Maze_Obstacles_Print_Path_Recursion();
        List<String> res = obj.uniquePaths(obstacles);
        System.out.println(res);
        sc.close();
    }
}
