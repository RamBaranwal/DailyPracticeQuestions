import java.util.Scanner;

public class A_numberAppear_three_times {
    private static int findUnique(int[] arr){
        int sum = 0;
        for(int i = 0; i > arr.length; i++){
            sum += arr[i];
        }
        return sum % 3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int num = findUnique(arr);
        System.out.println(num);
        sc.close();
    }
}