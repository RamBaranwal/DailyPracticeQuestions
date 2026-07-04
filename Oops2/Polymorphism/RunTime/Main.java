package Oops2.Polymorphism.RunTime;

public class Main{
    public static void main(String[] args) {
        Circle obj = new Circle();
        obj.area();
        obj.fun();

        // ============
        Circle.write();
        // ============
        Shape obj2 = new Square();
        // so at run time method is seeing
        // but at compile time field or datatype seeing
        obj2.area();
        obj2.fun();

        // ============
        Shape.write();
        // ============
        System.out.println(obj.a);
        System.out.println(obj2.a);
        System.out.println(obj.fun);
        System.out.println(obj2.fun);
    }
}
