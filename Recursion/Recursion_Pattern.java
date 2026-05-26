import java.util.Scanner;

public class Recursion_Pattern {
    private void pattern1(int n){
        triangle(n, 0);
    }
    private void triangle(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            System.out.print("* ");
            triangle(row, col + 1);
        }
        else{
            System.out.println();
            triangle(row - 1, 0);
        }
    }
    private void pattern2(int n){
        triangle2(n, 0);
    }
    private void triangle2(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            triangle2(row, col + 1);
            System.out.print("* ");
        }
        else{
            triangle2(row - 1, 0);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Recursion_Pattern obj = new Recursion_Pattern();
        obj.pattern1(n);
        obj.pattern2(n);
        sc.close();
    }
}
