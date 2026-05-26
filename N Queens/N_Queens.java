import java.util.Scanner;

public class N_Queens {
    private int findWaysNQueen(int n){
        boolean[][] board = new boolean[n][n];
        return queens(board , 0);
    }
    private int queens(boolean[][] board, int row){
        if(row == board.length){
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col){
        // vertical row
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // diagonally left
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row - i][col - i]){
                return false;
            }
        }

        // diagonally right
        int maxRight = Math.min(row, board.length - col - 1);
        for(int i = 1; i <= maxRight; i++){
            if(board[row - i][col + i]){
                return false;
            }
        }
        return true;
    }
    private void displayBoard(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // find the number ways we place the queens possible
        N_Queens obj = new N_Queens();
        int count = obj.findWaysNQueen(n);
        System.out.println(count);
        sc.close();
    }
}
