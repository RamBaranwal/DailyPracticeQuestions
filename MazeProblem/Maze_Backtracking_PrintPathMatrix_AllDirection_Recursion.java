import java.util.Arrays;
import java.util.Scanner;

public class Maze_Backtracking_PrintPathMatrix_AllDirection_Recursion {
    private void uniquePathsAllDirection(int[][] maze){
        int[][] path = new int[maze.length][maze[0].length];
        helper("", 0, 0, maze, path, 1);
    }
    private void helper(String p, int row, int col, int[][] maze, int[][] path, int steps){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = steps;
            // for(int[] num : path){
            //     for(int n : num){
            //         System.out.print(n + " ");
            //     }
            //     System.out.println();
            // }
            // formate
            // 1 0 0
            // 2 0 0
            // 3 4 5


            // System.out.println(Arrays.deepToString(path));
            // formate
            // [[1, 0, 0], [2, 0, 0], [3, 4, 5]]

            for(int[] nums : path){
                System.out.print(Arrays.toString(nums));
                System.out.println();
            }

            // formate
            // [1, 0, 0]
            // [2, 0, 0]
            // [3, 4, 5]

            System.out.println(p);
            // print the path => DRLU

            System.out.println();
            return;
        }

        // not going back to make the visited one 0
        if(maze[row][col] == 0){
            return;
        }
        maze[row][col] = 0;

        // set the path steps
        path[row][col] = steps;

        // not using = with given < or > because of the when if
        // row = 0 and again see row becomes -1 which is out of bound similarly for
        // row = maze.length - 1 row + 1 becomes out of bound

        if(row < maze.length - 1){
            helper(p + "D", row + 1, col, maze, path, steps + 1);
        }
        if(col < maze[0].length - 1){
            helper(p + "R", row, col + 1, maze, path, steps + 1);
        }
        if(row > 0){
            helper(p + "U", row - 1, col, maze, path, steps + 1);
        }
        if(col > 0){
            helper(p + "L", row, col - 1, maze, path, steps + 1);
        }

        // backtracking making all the visited path again 1
        //so next time if this column comes into new path it will aline
        maze[row][col] = 1;

        path[row][col] = 0;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Maze_Backtracking_PrintPathMatrix_AllDirection_Recursion obj = new Maze_Backtracking_PrintPathMatrix_AllDirection_Recursion();
        obj.uniquePathsAllDirection(maze);
        sc.close();
    }
}
