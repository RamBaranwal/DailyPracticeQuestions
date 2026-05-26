public class Recursion_function1 {
    static void fun(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        // fun(--n);
        fun(n--);
        // this make the infinite recursion call
    }
    public static void main(String[] args) {
        fun(5);
    }
}
