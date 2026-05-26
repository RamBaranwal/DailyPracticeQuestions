import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class N_Queens_UseArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> ans = solveNQueens(n);
        for (List<String> board : ans) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        sc.close();
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board, 0, res);
        return res;
    }

    static void helper(boolean[][] board, int row, List<List<String>> res) {
        // all queens placed
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (boolean[] r : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean cell : r) {
                    if (cell) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            res.add(temp);
            return;
        }

        // try every column
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                helper(board, row + 1, res);
                // backtrack
                board[row][col] = false;
            }
        }
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        // check upper rows
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal
        int leftMax = Math.min(row, col);
        for (int i = 1; i <= leftMax; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal
        int rightMax = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= rightMax; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }
}
