import java.util.Scanner;

public class ORDER_AGNOSTIC {
    private static int Agnostic(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        // find weather the array is into asccending order or not
        boolean isAsc = nums[start] < nums[end];

        while(start <= end){
            int mid = start + ((end - start) / 2);
            if(nums[mid] == target){
                return mid;
            }
            else{
                if(isAsc){
                    if(nums[mid] > target){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                else{
                    if(nums[mid] < target){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // this is used to remove the static

        // ORDER_AGNOSTIC obj = new ORDER_AGNOSTIC();
        // int index = obj.Agnostic(arr, k);

        // this is used when function have static because
        // static function call static functions and
        // non static functions are not able to call static functions
        int index = Agnostic(arr, k);
        System.out.println(index);
        sc.close();
    }
}
