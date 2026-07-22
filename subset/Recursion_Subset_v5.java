import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion_Subset_v5 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res, 0);
        return res;
    }
    private void helper(int[] arr, List<Integer> current, List<List<Integer>> res, int index){
        res.add(new ArrayList<>(current));
        for(int i = index; i < arr.length; i++){
            current.add(arr[i]);
            helper(arr, current, res, i + 1);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }

        Recursion_Subset_v5 obj = new Recursion_Subset_v5();
        List<List<Integer>> arr = obj.subsets(res);
        System.out.println(arr);
        sc.close();
    }
}
