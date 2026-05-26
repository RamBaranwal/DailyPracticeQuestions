import java.util.Arrays;
import java.util.Scanner;

public class Sudoku_fill {

    private boolean fillSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    for(int fill = 1; fill <= board.length; fill++){
                        if(isSafe(fill, board, i, j)){
                            board[i][j] = fill;
                            if(fillSudoku(board)){
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int nums, int[][] board, int row, int col) {
        // check for row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == nums) {
                return false;
            }
        }

        // check for col
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == nums) {
                return false;
            }
        }

        // for that box
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == nums) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        Sudoku_fill obj = new Sudoku_fill();
         if (obj.fillSudoku(board)) {

            for (int[] row : board) {
                System.out.println(Arrays.toString(row));
            }

        } else {
            System.out.println("No Solution Exists");
        }
        sc.close();
    }
}
