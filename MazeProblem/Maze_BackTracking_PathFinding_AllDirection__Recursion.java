import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Maze_BackTracking_PathFinding_AllDirection__Recursion {
    private List<String> uniquePathsAllDirection(int[][] maze){
        List<String> res = new ArrayList<>();
        int[] count = new int[1];
        helper(count, res, "", 0, 0, maze);
        System.out.println("Count = " + count[0]);
        return res;
    }
    private void helper(int[] count, List<String> res, String p, int row, int col, int[][] maze){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            count[0]++;
            res.add(p);
            return;
        }
        if(maze[row][col] == 1){
            return;
        }

        maze[row][col] = 1;

        if(row < maze.length - 1){
            helper(count, res, p + "D", row + 1, col, maze);
        }
        if(col < maze[0].length - 1){
            helper(count, res, p + "R", row, col + 1, maze);
        }
        if(row > 0){
            helper(count, res, p + "U", row - 1, col, maze);
        }
        if(col > 0){
            helper(count, res, p + "L", row, col - 1, maze);
        }

        maze[row][col] = 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        // put 1 for block and 0 to path
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Maze_BackTracking_PathFinding_AllDirection__Recursion obj = new Maze_BackTracking_PathFinding_AllDirection__Recursion();
        List<String> res = obj.uniquePathsAllDirection(maze);
        System.out.println(res);
        sc.close();
    }
}
