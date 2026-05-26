import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class IM_Recursion_Phone_Combinations {
    private List<String> findCombinations(String digit){
        return helper("", digit);
    }
    private List<String> helper(String p, String digit){
        if(digit.isEmpty()){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        int digitAt = digit.charAt(0) - '0';
        
        // if we dial 0 it will return from here
        if(digitAt == 0){
            return helper(p, digit.substring(1));
        }

        int start = (digitAt - 1) * 3;
        int count = 3;
        if(digitAt == 9){
            count = 2;
        }


        List<String> res = new ArrayList<>();
        for(int i = 0; i < count; i++){
            char ch = (char)(start + i + 'a');
            res.addAll(helper(p + ch, digit.substring(1)));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digit = sc.nextLine();
        IM_Recursion_Phone_Combinations obj = new IM_Recursion_Phone_Combinations();
        List<String> res = obj.findCombinations(digit);
        System.out.println(res);
        sc.close();
    }
}
//  1     2     3
// abc   def   ghi
//  4     5     6
// jkl   mno   pqr
//  7     8     9
// stu   vwx   yz