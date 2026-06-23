package Oops2.StaticUses.StaticBlock;

public class Main {

    static int a = 10;
    static int b;

    // firstly static is run then the obj is created and static only runs once
    // when the class is loaded first time
    static{
        System.out.println("I am static block");
        b = 4 * a;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println(Main.a + " " + Main.b);
        // this is also right but it is consider as the bad habit to access the static obj
        // because it does not need obj to run bit still we can run this
        // but by direct class we run it
        System.out.println(obj.a + " " + obj.b);

        Main.b = 4 * b;
        System.out.println(Main.a + " " + Main.b);

        Main obj2 = new Main();
        System.out.println(Main.a + " " + Main.b);
    }
}

class Box{

}