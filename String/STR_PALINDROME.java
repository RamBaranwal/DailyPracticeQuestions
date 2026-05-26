import java.util.Scanner;

public class STR_PALINDROME {
    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean find = isPalindrome(str);
        System.out.println(find);
        sc.close();
    }
}
