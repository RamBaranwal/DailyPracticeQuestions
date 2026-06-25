package Oops2.Polymorphism.CompileTime;

public class Circle extends Shape {
    int a = 40;
    @Override
    void area(){
        System.out.println("this is circle whose area is pi radius square");
    }
    String fun = "this is same name into parent and child but circle child is calling";
}
