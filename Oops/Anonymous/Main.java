package Oops.Anonymous;

public class Main {
    // class InnerCalss extends OuterClass{

    // }

    OuterClass obj = new OuterClass(){
        void sing(){
            System.out.println("singing");
        }

        public void call(){
            System.out.println("he is not singling");
            sing();
        }
    };

    SuperClass obj2 = new SuperClass(){
        @Override
        public void print(){

        }
    };

    SuperClass obj4 = () -> {

    };

    SystemIn sysIn = (int walk) -> {
        System.out.println("Walkin");
        return walk;
    };
    public static void main(String[] args) {
        Main m = new Main();

        m.obj.call();
        m.obj2.print();
        m.obj4.print();
        int result = m.sysIn.walk(10);

        SystemIn sysIn = (int walkong) -> {
            System.out.println("Walkin");
            return walkong;
        };

        sysIn.walk(5);
    }
}

@FunctionalInterface
interface SystemIn{
    int walk(int walked);
}

class OuterClass{

    void call(){
        System.out.println("calling");
    }
}

@FunctionalInterface
interface SuperClass{
    void print();
    // void sing(); // {
    //     System.out.println("default singing");
    // }
}

@FunctionalInterface
interface SystemUp{
    void show();
}
