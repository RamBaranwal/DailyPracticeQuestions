public class LEARN_RECURSION_V1 {
    public static void main(String[] args) {
        // we need to print the hello world 5 times but the conditions
        // 1. we don't make same function name -> like create this n times => private static void message()
        // 2. we don't call same function n times into psvm function
        // 3. we don't make to print n times System.out.println("Hello World") int the function message
        // Solution -> call message one time and then into that message call another function
        // this will not violate any terms and conditions
        message();
    }

    private static void message(){
        System.out.println("Hello world m");
        message1();
    }
    private static void message1(){
        System.out.println("Hello World m1");
        message2();
    }
    private static void message2(){
        System.out.println("Hello World m2");
        message3();
    }
    private static void message3(){
        System.out.println("Hello World m3");
        message4();
    }
    private static void message4(){
        System.out.println("Hello World m4");
    }
}
