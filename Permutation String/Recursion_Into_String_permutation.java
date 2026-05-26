import java.util.Scanner;

public class Recursion_Into_String_permutation {
    private void permutation(String str){
        permutation("", str);
    }
    private void permutation(String pStr, String upStr){
        if(upStr.isEmpty()){
            System.out.println(pStr);
            return;
        }

        char ch = upStr.charAt(0);
        for(int i = 0; i <= pStr.length(); i++){
            String first = pStr.substring(0, i);
            String second = pStr.substring(i, pStr.length());
            permutation(first + ch + second, upStr.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Recursion_Into_String_permutation obj = new Recursion_Into_String_permutation();
        obj.permutation(str);
        sc.close();
    }
}
