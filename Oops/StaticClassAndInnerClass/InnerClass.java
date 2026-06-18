package StaticClassAndInnerClass;

public class InnerClass {

    static class PlayStation{
        int price;
    }

    class Toy{
        int price;
    }
    public static void main(String[] args) {

        // this is how we access the static class

        // both are used for same purpose
        PlayStation obj = new PlayStation();
        PlayStation obj2 = new InnerClass.PlayStation();

        obj.price = 10;
        obj2.price = 30;

        // this is how we access not static class
        InnerClass obj3 = new InnerClass();
        Toy t1 = obj3.new Toy();

        t1.price = 40;

    }
}

// static class PlayStation{
//     int price;
// }