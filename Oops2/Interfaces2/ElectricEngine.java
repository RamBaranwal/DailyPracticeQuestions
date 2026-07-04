package Oops2.Interfaces2;

public class ElectricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Petrol Engine Started'");
    }

    @Override
    public void stop() {
        System.out.println("Petrol Engine Stoped");
    }

    @Override
    public void acc(){
        System.out.println("Petrol Engine Accelerating");
    }

    void brake(){
        System.out.println("good brakes");
    }
}
