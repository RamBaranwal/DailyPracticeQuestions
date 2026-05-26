import java.util.Scanner;

public class FindMinimumSum {
    private double findSum(double[] arr){
        double sum = 0;
        for(int i = 0; i < 6; i++){
            double min = arr[i];
            for(int j = i; j < i + 3; j++){
                min = Math.min(min, arr[j]);
            }
            sum += min;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[8];
        for(int i = 0; i < 8; i++){
            arr[i] = sc.nextDouble();
        }
        FindMinimumSum obj = new FindMinimumSum();
        double res = obj.findSum(arr);
        System.out.println(res);
        sc.close();
    }
}
