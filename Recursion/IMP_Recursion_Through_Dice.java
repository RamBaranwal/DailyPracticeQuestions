import java.util.Scanner;

public class IMP_Recursion_Through_Dice {
    private void combinationOfDice(int target){
        helper("", target);
    }
    private void helper(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= target; i++){
            helper(p + i, target - i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        IMP_Recursion_Through_Dice obj = new IMP_Recursion_Through_Dice();
        obj.combinationOfDice(target);
        sc.close();
    }
}
