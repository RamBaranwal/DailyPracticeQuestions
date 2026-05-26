import java.util.Scanner;

public class Recursion_Into_String_v3 {
    private String skipLetter(String str, String letter){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith(letter)){
            return skipLetter(str.substring(letter.length()), letter);
        }
        else{
            return ch + skipLetter(str.substring(1), letter);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String letter = sc.nextLine();
        Recursion_Into_String_v3 obj = new Recursion_Into_String_v3();
        System.out.println(obj.skipLetter(str, letter));
        sc.close();
    }
}
