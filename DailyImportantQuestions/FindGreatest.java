import java.util.Scanner;

public class FindGreatest {

    private int findGreatest(int n){
        String str = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int res = 0;
        if(sb.charAt(0) != '3'){
            sb.replace(0, 1, "3");
            str = sb.toString();
            res =  Integer.parseInt(str);
        }
        else if(sb.charAt(1) != '3'){
            sb.replace(1, 2, "3");
            str = sb.toString();
            res =  Integer.parseInt(str);
        }
        else{
            res =  Integer.parseInt(str);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        FindGreatest obj = new FindGreatest();
        int res = obj.findGreatest(n);
        System.out.println(res);
        sc.close();
    }
}