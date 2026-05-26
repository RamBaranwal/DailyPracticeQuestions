import java.util.Scanner;

public class Recursion_findTargetValue {
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // this is finding the index of the target value
    ////////////////////////////////////////////////
    private int findTargetIndex(int[] arr, int target){
        return helperIndex(arr, target, 0);
    }
    private int helperIndex(int[] arr, int target, int index){
        if(index > arr.length - 1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        else{
            return helperIndex(arr, target, index + 1);
        }
    }
    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // this is the finding the target value it have or not
    //////////////////////////////////////////////////////
    private boolean findTarget(int[] arr, int target){
        return helperFind(arr, target, 0);
    }
    private boolean helperFind(int[] arr, int target, int index){
        if(index == arr.length){
            return false;
        }
        return (arr[index] == target || helperFind(arr, target, index + 1));
    }

    //\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // this is finding the target from last index
    /////////////////////////////////////////////
    private int findTargetLastIndex(int[] arr, int target){
        return helperFromLastIndex(arr, target, arr.length - 1);
    }
    private int helperFromLastIndex(int[] arr, int target, int index){
        if(index == -1){
            return -1;
        }
        if(arr[index] == target){
            return index;
        }
        return helperFromLastIndex(arr, target, index - 1);
    }
    // main body//////////////////////////////////////////
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        Recursion_findTargetValue obj = new Recursion_findTargetValue();
        int index = obj.findTargetIndex(res, target);
        boolean targetFound = obj.findTarget(res, target);
        int lastIndex = obj. findTargetLastIndex(res, target);
        System.out.println(index);
        System.out.println(targetFound);
        System.out.println(lastIndex);
        sc.close();
    }
}
