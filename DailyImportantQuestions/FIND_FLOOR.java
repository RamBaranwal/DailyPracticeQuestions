import java.util.Scanner;

public class FIND_FLOOR {
    private int findfloor(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(target < arr[start]) return -1;
        while(start < end){
            int mid = start + ((end - start) / 2);
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        FIND_FLOOR obj = new FIND_FLOOR();
        int cel = obj.findfloor(nums, k);
        System.out.print(cel);
        sc.close();
    }
}
