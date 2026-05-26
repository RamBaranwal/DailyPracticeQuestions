import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_Subset_ArrayList {
    private ArrayList<String> subnets(String str){
        return subset("", str);
    }
    private ArrayList<String> subset(String rest, String str){
        if(str.isEmpty()){
            ArrayList<String> res = new ArrayList<>();
            res.add(rest);
            return res;
        }
        
        char ch = str.charAt(0);
        ArrayList<String> left = subset(rest + ch, str.substring(1));
        ArrayList<String> right = subset(rest, str.substring(1));
        left.addAll(right);
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Recursion_Subset_ArrayList obj = new Recursion_Subset_ArrayList();
        ArrayList<String> res = obj.subnets(str);
        System.out.println(res);
        sc.close();
    }
}
