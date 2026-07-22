import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recursion_Backtracking_Subset {
    private List<List<Integer>> subnets(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        subset(arr, 0, new ArrayList<>(), res);
        return res;
    }
    private List<List<Integer>> subset(int[] arr, int index, List<Integer> current, List<List<Integer>> res){
        res.add(new ArrayList<>(current));
        for(int i = index; i < arr.length; i++){
            current.add(arr[i]);

            subset(arr, i + 1, current, res);

            current.remove(current.size() - 1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }

        Recursion_Backtracking_Subset obj = new Recursion_Backtracking_Subset();
        List<List<Integer>> arr = obj.subnets(res);
        System.out.println(arr);
        sc.close();
    }
}