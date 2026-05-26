import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Recursion_Subset_v4 {
    private List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        helper(arr, outer);
        return outer;
    }
    private void helper(int[] arr, List<List<Integer>> outer){
        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Recursion_Subset_v4 obj = new Recursion_Subset_v4();
        List<List<Integer>> res = obj.subsets(arr);
        System.out.println(res);
        sc.close();
    }
}
