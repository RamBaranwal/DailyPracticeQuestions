// import java.util.Arrays;
import java.util.Scanner;
public class Sudoku_v2 {

    // private boolean fillSudoku(int[][] board) {
    //     for (int i = 0; i < board.length; i++) {
    //         for (int j = 0; j < board.length; j++) {
    //             if (board[i][j] == 0) {
    //                 for(int fill = 1; fill <= board.length; fill++){
    //                     if(isSafe(fill, board, i, j)){
    //                         board[i][j] = fill;
    //                         if(fillSudoku(board)){
    //                             return true;
    //                         }
    //                         board[i][j] = 0;
    //                     }
    //                 }
    //                 return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

    private boolean solve(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft == false) break;
        }
        if(emptyLeft == true) return true;

        // backtrack
        for(int number = 1; number <= board.length; number++){
            if(isSafe(number, board, row, col)){
                board[row][col] = number;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
    private void display(int[][] board){
        for(int[] nums : board){
            for(int num : nums){
                System.out.print(num + " ");
            }
            System.out.println();
        }
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

        Sudoku_v2 obj = new Sudoku_v2();
        if(obj.solve(board)){
            obj.display(board);
        }
        else{
            System.out.println("Cannot solve it");
        }
        sc.close();
    }
}