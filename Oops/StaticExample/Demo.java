class Main {

    // Static Variable
    static int a = 10;

    // Static Block
    static {
        System.out.println("Static Block Executed");
        a = a * 2;
    }

    // Static Method
    static void fun() {
        System.out.println("Static Method Executed");
        System.out.println("a = " + a);
    }

    Main() {
        System.out.println("Constructor Executed");
    }
}

public class Demo {
    public static void main(String[] args) {

        System.out.println("Main Started");
        System.out.println(Main.a);

        Demo d1 = new Demo();
        System.out.println(Main.a);
        
        Main.fun();
        System.out.println(Main.a);

        Demo d2 = new Demo();
        System.out.println(Main.a);
    }
}