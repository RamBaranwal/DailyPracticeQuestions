import java.util.Scanner;

public class CountAndSays {
    private String printNumber(int n){
        if(n == 1){
            return "1";
        }
        
        String prev = printNumber(n - 1);

        String res = "";

        int i = 0;
        // int lastI = 0;
        int lastJ = 0;
        for(int j = 0; j < prev.length(); j++){
            if(prev.charAt(i) != prev.charAt(j)){
                int diff = j - i;
                res = res + diff;
                res = res + prev.charAt(i);
                i = j;
            }
            // lastI = i;
            lastJ = j;
        }
        // int diff = lastJ - lastI + 1;
        int diff = lastJ - i + 1;
        res = res + diff;
        // res = res + prev.charAt(lastI);
        res = res + prev.charAt(i);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        int n = sc.nextInt();
        CountAndSays obj = new CountAndSays();
        String str = obj.printNumber(n);
        System.out.println(str);
        sc.close();
    }
}
