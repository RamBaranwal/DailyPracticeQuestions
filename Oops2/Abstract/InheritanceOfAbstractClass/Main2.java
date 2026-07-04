package Oops2.Abstract.InheritanceOfAbstractClass;

abstract class Vehicle {

    abstract void start();
}

abstract class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with a key");
    }

    abstract void drive();
}

class BMW extends Car {

    @Override
    void drive() {
        System.out.println("BMW is driving");
    }

    @Override
    void start() {
        super.start();
    }
}

public class Main2 {
    public static void main(String[] args) {

        BMW obj = new BMW();

        obj.start();
        obj.drive();
    }
}
