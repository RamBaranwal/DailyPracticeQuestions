import java.util.Scanner;

public class I_CountPermutaiton_Recursion {
    private int countPermutaion(String str){
        return helper("", str);
    }
    private int helper(String p, String up){
        if(up.isEmpty()){
            return 1;
        }

        char ch = up.charAt(0);
        
        int count = 0;
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count = count + helper(first + ch + second, up.substring(1));
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        I_CountPermutaiton_Recursion obj = new I_CountPermutaiton_Recursion();
        int count = obj.countPermutaion(str);
        System.out.println(count);
        sc.close();
    }
}
