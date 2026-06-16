package Oops.Inherit;

public class Car extends Vehical{
    String color;

    Car(){
        System.out.println("this is car default constructor");
    }

    Car(String paint){
        this.color = paint;
        System.out.println("this is paint constructor"); 
    }
    void start(){
        System.out.println(this);
        System.out.println(this.name + " name of Car & " + this.color + " its color");
    }
    public static void main(String[] args) {
        Car obj = new Car();
        obj.name = "i10";
        obj.wheels = 4;
        obj.color = "Red";
        obj.start();
        // System.out.println(this.name + );
        // cannot use this inside the psvm
    }
}
