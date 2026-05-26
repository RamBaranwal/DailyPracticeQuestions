import java.util.Scanner;

public class Recursion_Into_String_v5 {
    private void skipAppleNotApp(String str, String letter){
        helper("", str, letter);
    }
    private void helper(String newStr, String str, String letter){
        if(str.isEmpty()){
            System.out.println(newStr);
            return;
        }

        char ch = str.charAt(0);
        if(str.startsWith("apple")){
            helper(newStr + "apple", str.substring(5), letter);
        }
        else if(str.startsWith(letter)){
            helper(newStr, str.substring(letter.length()), letter);
        }
        else{
            helper(newStr + ch, str.substring(1), letter);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String letter = sc.nextLine();
        Recursion_Into_String_v5 obj = new Recursion_Into_String_v5();
        obj.skipAppleNotApp(str, letter);
        sc.close();
    }
}
