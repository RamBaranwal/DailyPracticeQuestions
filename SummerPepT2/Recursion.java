// package SummerPepT2;
import java.io.*;
public class Recursion {

    private int findRecursion(int n){

        if(n <= 100){
            return findRecursion(findRecursion(n + 11));
        }
        else{
            return n - 10;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);

        Recursion obj = new Recursion();
        int res = obj.findRecursion(n);
        System.out.println(res);
    }
}
