import java.util.Scanner;
import java.util.List;
public class Recursion_Into_String_Permutation_v2 {
    private List<String> permutation(String str){
        return permutation("", str);
    }
    private List<String> permutation(String p, String up){
        if()
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Recursion_Into_String_Permutation_v2 obj = new Recursion_Into_String_Permutation_v2();
        List<String> res = obj.permutation(str);
        System.out.println(res);
        sc.close();
    }
}
