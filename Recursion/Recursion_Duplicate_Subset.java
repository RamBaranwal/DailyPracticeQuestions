import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Recursion_Duplicate_Subset {
    private static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        helper(arr, outer);
        return outer;
    }

    private static void helper(int[] arr, List<List<Integer>> outer){
        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++){
            start = 0;
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }
            end = outer.size() - 1;
            int n = outer.size();
            for(int j = start; j < n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                int element = arr[i];
                inner.add(element);
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

        List<List<Integer>> res = subset(arr);
        System.out.println(res);
        sc.close();
    }
}
