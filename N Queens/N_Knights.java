import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_Knights {
    private List<List<String>> knightLocations(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(res, board, 0, 0, n);
        return res;
    }

    private void helper(List<List<String>> res, boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        sb.append("K");
                    } else {
                        sb.append(".");
                    }
                }
                arr.add(sb.toString());
            }
            res.add(arr);
            return;
        }

        if (board.length == row) {
            return;
        }

        if (col == board.length) {
            helper(res, board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            helper(res, board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        // if not aplicable into the current col skip it go next
        helper(res, board, row, col + 1, knights);
    }

    private boolean isSafe(boolean[][] board, int row, int col) {

        // upper left check not out of board and not not have knight at that place
        if (row - 2 >= 0 && col - 1 >= 0 && board[row - 2][col - 1]) {
            return false;
        }

        // upper right
        if (row - 2 >= 0 && col + 1 < board.length && board[row - 2][col + 1]) {
            return false;
        }

        // left upper
        if (row - 1 >= 0 && col - 2 >= 0 && board[row - 1][col - 2]) {
            return false;
        }

        // right upper
        if (row - 1 >= 0 && col + 2 < board.length && board[row - 1][col + 2]) {
            return false;
        }

        // no need to see the down side
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        N_Knights obj = new N_Knights();
        List<List<String>> res = obj.knightLocations(n);
        for (List<String> board : res) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
        sc.close();
    }
}