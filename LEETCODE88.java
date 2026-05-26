// import java.util.Scanner;

public class LEETCODE88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);

        // // Input m and n
        // int m = sc.nextInt();
        // int n = sc.nextInt();

        // int[] nums1 = new int[m + n];
        // int[] nums2 = new int[n];

        // // Input nums1 (only m elements)
        // for (int i = 0; i < m; i++) {
        //     nums1[i] = sc.nextInt();
        // }

        // // Input nums2
        // for (int i = 0; i < n; i++) {
        //     nums2[i] = sc.nextInt();
        // }
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;


        LEETCODE88 obj = new LEETCODE88();
        obj.merge(nums1, m, nums2, n);

        // Output result
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // sc.close();
    }
}
