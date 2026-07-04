package Oops2.Polymorphism.RunTime;

public class Square extends Shape {
    // some extra rules if any function into parent is final is not again declareable into child class
    // void area(){
    //     System.out.println("This is square whose area is side square");
    // }
    // void fun(){
    //     System.out.println("this is of child square of shape parent class");
    // }
    static void write(){
        System.out.println("write fun inside the circle of parent shape class");
    }
    int a = 20;
    String fun = "this is same name into parent and child but square child is calling";
}
