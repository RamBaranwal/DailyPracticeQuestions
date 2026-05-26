import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Genrate_Paranthesis_Recursion_v2 {
    public List<String> GenrateParanthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(0, 0, n, "", list);
        return list;
    }
    private void helper(int l, int r, int n, String s, List<String> list){
        if(r == n){
            list.add(s);
            return;
        }
        if(l < n) helper(l + 1, r, n, s + "(", list);
        if(r < l) helper(l, r + 1, n, s + ")", list);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Genrate_Paranthesis_Recursion_v2 obj = new Genrate_Paranthesis_Recursion_v2();
        List<String> res = obj.GenrateParanthesis(n);
        System.out.println(res);
        sc.close();
    }
}