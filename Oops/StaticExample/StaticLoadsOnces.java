public class StaticLoadsOnces {
    static int a = 20;
    static int b;

    static{
        System.out.println("I am static block");
        b = a * 3;
    }

    // this is run once when the first obj is created when the class is loaded first time
    static void fun(){
        System.out.println("this is fun block");
    }

    public static void main(String[] args) {
        // only creating this obj first time it run static block automatically
        // static is access by both method static non-static method
        StaticLoadsOnces obj = new StaticLoadsOnces();
        obj.fun();

        StaticLoadsOnces.fun();

        fun();
        
        System.out.println(StaticLoadsOnces.a + " " + obj.b);

        obj.b *= 3;

        StaticLoadsOnces.a += 5;
        System.out.println(StaticLoadsOnces.a + " " + StaticLoadsOnces.b);

        StaticLoadsOnces obj2 = new StaticLoadsOnces();
        System.out.println(StaticLoadsOnces.a + " " + StaticLoadsOnces.b);

    }
}
