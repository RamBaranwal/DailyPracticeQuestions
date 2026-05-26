import java.util.ArrayList;
import java.util.Scanner;

public class I_Recursion_Permutation_ArrayList {
    private ArrayList<String> permutation(String str){
        return helper("", str);
    }
    private ArrayList<String> helper(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        char ch = up.charAt(0);

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            list.addAll(helper(f + ch + s, up.substring(1)));
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        I_Recursion_Permutation_ArrayList obj = new I_Recursion_Permutation_ArrayList();
        ArrayList<String> list = obj.permutation(str);
        System.out.println(list);
        sc.close();
    }
}
