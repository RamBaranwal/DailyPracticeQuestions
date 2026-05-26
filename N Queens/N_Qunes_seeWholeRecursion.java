import java.util.Scanner;
public class N_Qunes_seeWholeRecursion {

    private int findNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }

    private int queens(boolean[][] board, int row) {

        // solution found
        if (row == board.length) {

            System.out.println("Solution Found:");
            displayBoard(board);
            System.out.println();

            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {

            System.out.println("Trying row " + row + " col " + col);

            if (isSafe(board, row, col)) {

                System.out.println("Safe -> Place Queen at (" + row + "," + col + ")");

                board[row][col] = true;

                displayBoard(board);
                System.out.println();

                count += queens(board, row + 1);

                // backtracking
                System.out.println("Backtracking from (" + row + "," + col + ")");

                board[row][col] = false;

                displayBoard(board);
                System.out.println();
            }
            else {
                System.out.println("Not Safe at (" + row + "," + col + ")");
                System.out.println();
            }
        }

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {

        // vertical
        for (int i = 0; i < row; i++) {

            if (board[i][col]) {
                return false;
            }
        }

        // left diagonal
        int maxLeft = Math.min(row, col);

        for (int i = 1; i <= maxLeft; i++) {

            if (board[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal
        int maxRight = Math.min(row, board.length - col - 1);

        for (int i = 1; i <= maxRight; i++) {

            if (board[row - i][col + i]) {
                return false;
            }
        }

        return true;
    }

    private void displayBoard(boolean[][] board) {

        for (boolean[] row : board) {

            for (boolean element : row) {

                if (element) {
                    System.out.print("Q ");
                }
                else {
                    System.out.print(". ");
                }
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        N_Qunes_seeWholeRecursion obj = new N_Qunes_seeWholeRecursion();

        int count = obj.findNQueens(n);

        System.out.println("Total Solutions = " + count);

        sc.close();
    }
}

