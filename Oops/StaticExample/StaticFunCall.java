package StaticExample;

public class StaticFunCall {
    public static void main(String[] args) {
        fun();

        greeting3();

        fun2();

        // Non-static methods
        StaticFunCall obj = new StaticFunCall();

        obj.greeting();

        obj.greeting2();
    }
    // we can define obj any wher not only inside the psvm but into any function

    static void fun() {
        StaticFunCall obj = new StaticFunCall();
        obj.greeting();
    }

    void greeting() {
        System.out.println("hello haa ji");
    }

    // method 2
    static void greeting3() {
        System.out.println("hello naa ji");
    }

    static void fun2() {
        greeting3();
    }

    void greeting2() {
        System.out.println("hello ji");
    }
}
