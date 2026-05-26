import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_addIndexTargetFound {
    ////////////////////////////////////////////////////////////
    // use unwinding method and all element after the execution
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private ArrayList<Integer> findTargetIndexes(int[] arr, int target){
        return helper(arr, target, 0);
    }
    private ArrayList<Integer> helper(int[] arr, int target, int index){
        ArrayList<Integer> res = new ArrayList<>();
        if(index == arr.length){
            return res;
        }
        if(arr[index] == target){
            res.add(index);
        }
        // this is the main line see it return arraylist
        ArrayList<Integer> below = helper(arr, target, index + 1);
        // at unwinding time it will add all the things
        res.addAll(below);
        return res;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // take the parameter inside the function call it helps to see the recursion easily
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private ArrayList<Integer> findTargetIndexesM2(int[] arr, int target){
        ArrayList<Integer> list = new ArrayList<>();
        helper(arr, target, 0, list);
        return list;
    }

    private void helper(int[] arr, int target, int index, ArrayList<Integer> list){
        if(index == arr.length){
            return;
        }
        if(arr[index] == target){
            list.add(index);
        }
        helper(arr, target, index + 1, list);
    }

    // main block ////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Recursion_addIndexTargetFound obj = new Recursion_addIndexTargetFound();
        ArrayList<Integer> arr = obj.findTargetIndexes(res, target);
        ArrayList<Integer> nums = obj.findTargetIndexesM2(res, target);
        System.out.println(arr);
        System.out.println(nums);
        sc.close();
    }
}
