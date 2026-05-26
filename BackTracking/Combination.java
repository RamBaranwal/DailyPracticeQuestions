import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Combination {
    private List<List<Integer>> findCombinations(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, target, new ArrayList<>(), res);
        return res;
    }
    private void helper(int index, int[] nums, int target, List<Integer> current, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(current));
            return;
        }
        if(target < 0 || nums.length == index){
            return;
        }

        // take it
        current.add(nums[index]);
        helper(index, nums, target - nums[index], current, res);

        current.remove(current.size() - 1);
        helper(index + 1, nums, target, current, res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Combination obj = new Combination();
        List<List<Integer>> arr = obj.findCombinations(res, target);
        System.out.println(arr);
        sc.close();
    }
}
