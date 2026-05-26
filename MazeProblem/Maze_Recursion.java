import java.util.Scanner;

public class Maze_Recursion {
    private int findUniquePath(int row, int col){
        return helper(0, 0, col - 1, row - 1);
    }
    private int helper(int cc, int cr, int col, int row){
        if(cc == col && cr == row){
            return 1;
        }
        if(cr > row || cc > col){
            return 0;
        }
        
        // System.out.println("" + cc + cr);
        int right = helper(cc + 1, cr, col, row);
        // System.out.println("" + cc + cr);
        int down = helper(cc, cr + 1, col, row);
        // System.out.println("" + cc + cr);
        return right + down;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        Maze_Recursion obj = new Maze_Recursion();
        int n = obj.findUniquePath(row, col);
        System.out.println(n);
        sc.close();
    }
}
