import java.util.Scanner;

public class I_Recursion_Subset {
    private void subset(String str){
        subset("", str);
    }
    private void subset(String rest, String str){
        if(str.isEmpty()){
            System.out.println(rest);
            return;
        }

        char ch = str.charAt(0);
        subset(rest + ch, str.substring(1));
        subset(rest, str.substring(1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        I_Recursion_Subset obj = new I_Recursion_Subset();
        obj.subset(str);
        sc.close();
    }
}
