import java.util.*;

public class I_Recursion_Subset_v3 {

    public static void solve(List<List<Integer>> outer, List<Integer> current, int index, int[] arr) {
        
        // base condition
        if (index >= arr.length) {
            outer.add(new ArrayList<>(current));
            return;
        }

        // exclude
        solve(outer, current, index + 1, arr);

        // include
        int element = arr[index];
        current.add(element);
        solve(outer, current, index + 1, arr);

        // backtrack (important in Java)
        current.remove(current.size() - 1);
    }

    public static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int index = 0;

        solve(ans, output, index, arr);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> ans = subset(arr);

        System.out.println("Subset is:");
        for (List<Integer> subset : ans) {
            System.out.print("{ ");
            for (int val : subset) {
                System.out.print(val + " ");
            }
            System.out.println("}");
        }

        sc.close();
    }
}