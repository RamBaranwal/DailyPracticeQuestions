package Oops2.SingletonClass;

public class Main {
    public static void main(String[] args) {

        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        SingletonClass obj3 = SingletonClass.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        System.out.println(obj1 == obj2);
        System.out.println(obj2 == obj3);
        System.out.println(obj1 == obj3);
    }
}