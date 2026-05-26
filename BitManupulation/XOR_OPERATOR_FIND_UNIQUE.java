import java.util.Scanner;

public class XOR_OPERATOR_FIND_UNIQUE {
    private static int findUnique(int[] arr){
        int res = 0;
        if(arr.length % 2 == 0) return -1;
        for(int i = 0; i < arr.length; i++){
            res = arr[i] ^ res;
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
        int unique = findUnique(res);
        System.out.println(unique);
        sc.close();
    }
}

// XOR{^} is used
// a | b
// 0 | 0 => 0
// 1 | 1 => 0
// 0 | 1 => 1
// 1 | 0 => 1