package Oops2.FinalKeyWord;

public class Final {
    public static void main(String[] args) {
        final A obj1 = new A();
        // cannot reassign
        // A.salary = 1000;

        obj1.name = "Rishu";

        System.out.println(obj1.name);

        obj1.name = "Rishu Baranwal";
        System.out.println(obj1.name);

        // due to final of obj1 this obj cannot be reassign
        // obj1 = new A();

        A obj2 = new A();
        obj2.name = "hero";
        System.out.println(obj2);
        // both the time the values are reassign so its refrence is changed
        System.out.println(obj2.name);
        obj2 = new A();
        System.out.println(obj2);
    }
}

class A{
    // always assign the value when declaring
    final int salary = 300000;
    String name;
}
