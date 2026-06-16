package Oops.InheritAndSuper;

public class Car extends Vehical{
    String color;

    Car(){
        // super();
        super(2);
        System.out.println("this is car default constructor");
    }

    Car(String paint){
        this.color = paint;
        System.out.println("this is paint constructor"); 
    }
    void start(){
        Scoter scObj = new Scoter();
        scObj.breaking(this);
        System.out.println(this);
        System.out.println(this.name + " name of Car & " + this.color + " its color");
    }

    Car breaking(){
        return this;
    }

    public static void main(String[] args) {
        Car obj = new Car();
        System.out.println(obj.wheels);
        obj.name = "i10";
        obj.wheels = 4;
        obj.color = "Red";
        obj.start();
        System.out.println(obj.wheels);
        // this start override the parent start due to its presence 
        // if it is not present it search it into previous parent 
        // then before of it and further on
        // System.out.println(this.name + );
        // cannot use this inside the psvm

    }
}

class Scoter{
    void breaking (Car car){
        System.out.println("this is car inside the scoter");
        System.out.println(car.name);
        System.out.println(car.color);
    }
} 