import java.util.Scanner;

public class FIND_CELING {
    private int findCeling(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        if(target > arr[end]) return -1;
        while(start <= end){
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
        return start;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        FIND_CELING obj = new FIND_CELING();
        int cel = obj.findCeling(nums, k);
        System.out.print(cel);
        sc.close();
    }
}
