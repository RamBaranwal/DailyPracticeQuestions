public class LEARN_RECURSION_V2 {
    // print 1 tp 5 by recursion
    public static void main(String[] args) {
        int n = 1;
        print(n);
    }
    private static void print(int n){
        if(n == 5){
            System.out.println(5);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }
}
