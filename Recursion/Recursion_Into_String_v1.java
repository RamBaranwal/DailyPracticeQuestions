import java.util.Scanner;

public class Recursion_Into_String_v1 {
    private void skipA(String str){
        // String newStr = "";
        helper("", str);
    }
    private void helper(String newStr, String str){
        if(str.isEmpty()){
            System.out.println(newStr);
            return;
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            helper(newStr, str.substring(1));
        }
        else{
            helper(newStr + ch, str.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Recursion_Into_String_v1 obj = new Recursion_Into_String_v1();
        obj.skipA(str);                  // this is referenced one that modified but not disturbed the original String
        System.out.println(str);         // actual String is not modified we make new one
        sc.close();
    }
}
