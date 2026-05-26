import java.util.Scanner;

public class Maze_Obstacles_Count_Recursion_v1 {
    private int helper(int row, int col, int[][] obstacleGrid){
        if(row > obstacleGrid.length - 1 || col > obstacleGrid[0].length - 1){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1){
            return 1;
        }


        int down = helper(row + 1, col, obstacleGrid);

        int right = helper(row, col + 1, obstacleGrid);

        return down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return helper(0, 0, obstacleGrid);
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
        Maze_Obstacles_Count_Recursion_v1 obj = new Maze_Obstacles_Count_Recursion_v1();
        int count = obj.uniquePathsWithObstacles(obstacles);
        System.out.println(count);
        sc.close();

    }
}

