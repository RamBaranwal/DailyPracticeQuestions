package Oops2.Polymorphism.RunTime;

public class Circle extends Shape {
    int a = 40;
    // cannot override because its function already parent say final so not again override this
    // @Override
    // void area(){
    //     System.out.println("this is circle whose area is pi radius square");
    // }
    @Override
    void fun(){
        System.out.println("this is of child circle of shape parent class");
    }

    // @Override
    // static is not override
    static void write(){
        System.out.println("write fun inside the circle of parent shape class");
    }

    String fun = "this is same name into parent and child but circle child is calling";
}
