import java.util.Scanner;

public class RecursionTowerOfHanoi {
    private void towerOfHanoi(int n, char source, char helper, char destination){
        if(n == 0){
            return;
        }
        // System.out.println("" + n + source + " -> " + destination);
        towerOfHanoi(n - 1, source, destination, helper);
        System.out.println(source + " -> " + destination);   // System.out.println("" + n + source + " -> " + destination);
        towerOfHanoi(n - 1, helper, destination, source);
        // System.out.println("" + n + source + " -> " + destination);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RecursionTowerOfHanoi obj = new RecursionTowerOfHanoi();
        obj.towerOfHanoi(n, 'A', 'B', 'C');
        sc.close();
    }
}
