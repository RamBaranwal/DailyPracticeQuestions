package Oops2.Polymorphism.CompileTime;

public class Shape {
    int a = 90;
    String fun = "this is same name into parent and child but shape parent is calling";
    // same name
    // but =>
    // -> different parameter type
    // -> different number of data types inside parameter
    // -> different order of same data types
    // -> and different constructor overload as we see inside inheritance of box file
    void area(){
        System.out.println("this is only shape whose are not easily getable");
    }
    int area(int a){
        return -1;
    }
    int area(double a){
        return 1;
    }
    double area(String a, int b){
        return b;
    }

    double area(int a, String b){
        return a;
    }

    // return type not affect the run time polymorphism
    // like
    // => as we see the down side of example same name different datatype return but error comes
    // long area(){
    //     return 0;
    // }
}
