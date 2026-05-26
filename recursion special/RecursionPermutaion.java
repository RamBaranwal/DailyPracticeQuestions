import java.util.Scanner;

public class RecursionPermutaion {
    private void permutations(String str){
        helper("", str);
    }
    private void helper(String p, String up){
        if(up.isEmpty()){
            System.out.print(p + " ");
            return;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            helper(first + ch + second, up.substring(1));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        RecursionPermutaion obj = new RecursionPermutaion();
        obj.permutations(str);
        sc.close();
    }
}
