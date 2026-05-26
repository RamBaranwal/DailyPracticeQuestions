import java.util.Scanner;

public class DiceThrough {
    private void findCombinations(int n ){
        helper("", n);
    }
    private void helper(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i = 1; i <= 6 && i <= target; i++){
            helper(p + i, target - i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // to form the n target
        int n = sc.nextInt();
        DiceThrough obj = new DiceThrough();
        obj.findCombinations(n);
        sc.close();
    }
}
