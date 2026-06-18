package Oops.Abstract;

public class AbstractLearn {
    public static void main(String[] args) {

        Car car = new Car();

        car.vehicleWheels(4);

        int seats = car.noOfSeats(7);
        System.out.println("This car has " + seats + " seats");

        car.stop();
    }
}

abstract class Vehicle{
    // abstract int wheels;
    int wheels;
    abstract void vehicleWheels(int wheels);

    abstract int noOfSeats(int num);

    void stop(){
        System.out.println("The car is stopped");
    }

}
class Car extends Vehicle{
    @Override
    void vehicleWheels(int wheels) {
        this.wheels = wheels;
        System.out.println("This car has " + this.wheels + " wheels");
    }

    @Override
    int noOfSeats(int num) {
        return num;
    }
}   
