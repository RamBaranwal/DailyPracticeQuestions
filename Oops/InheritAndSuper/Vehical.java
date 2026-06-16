package Oops.InheritAndSuper;

public class Vehical {

    Vehical(){
        System.out.println("this is default constructor of Vehical");
    }

    Vehical(int wheels){
        this.wheels = wheels;
        System.out.println("this is wheels constructor");
    }
    public static void main(String[] args) {
        System.out.println("Vehicel is running");
        // String name;
        // THIS IS NOT REACHABLE by the car extended child
    }
    String name;
    int wheels;
    void start(){
        System.out.println("vehical start inside the void");
    }
}

// class Car{
//     int wheels;

//     void print(){
//         System.out.println("this car has " + this.wheels);
//     }
// }
