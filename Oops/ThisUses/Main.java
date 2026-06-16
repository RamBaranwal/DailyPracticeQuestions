package Oops.ThisUses;
class Car {

    String name;
    String color;

    Car(String name, String color) {
        this.name = name;      // this.variable
        this.color = color;
    }

    void display() {
        System.out.println("Name : " + this.name);
        System.out.println("Color: " + this.color);
    }

    void start() {
        System.out.println("\nCar Starting...");
        System.out.println(this);
        this.display();        // this.method()

        Garage garage = new Garage();

        garage.inspect(this);  // method(this)
    }

    Car repaint(String newColor) {
        this.color = newColor;

        return this;           // return this
    }
}

class Garage {

    void inspect(Car car) {

        System.out.println("\nGarage Inspecting Car");

        System.out.println("Name : " + car.name);
        System.out.println("Color: " + car.color);

        System.out.println("\nSame Object ?");
        System.out.println(car);
        System.out.println(this);
    }
}

public class Main {

    public static void main(String[] args) {

        Car obj = new Car("i10", "Red");

        System.out.println("Object Address:");
        System.out.println(obj);

        obj.start();

        Car temp = obj.repaint("Blue");

        System.out.println("\nAfter Repaint");

        System.out.println("obj  : " + obj);
        System.out.println("temp : " + temp);

        System.out.println("Same Object: " + (obj == temp));

        obj.display();
    }
}
