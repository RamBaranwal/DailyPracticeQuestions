import java.util.Scanner;

public class Recursion_Into_String_v2 {
    private String skipA(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch = str.charAt(0);
        if(ch == 'a'){
            return skipA(str.substring(1));
        }
        else{
            return ch + skipA(str.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Recursion_Into_String_v2 obj = new Recursion_Into_String_v2();
        System.out.println(obj.skipA(str));
        System.out.println(str);
        sc.close();
    }
}
