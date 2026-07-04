package Oops2.Interfaces;

public class Car implements Engine, EngineProperties {

    int b = 20;

    private String engineName;
    private int speed;

    public Car(String engineName) {
        this.engineName = engineName;
        this.speed = 0;
    }

    @Override
    public void start() {
        if(this.speed > 0){
            System.out.println("Car is already running");
        }
        else{
            System.out.println(engineName + " engine started.");
        }
    }

    @Override
    public void stop() {
        if (speed > 0) {
            System.out.println("❌ Cannot stop the engine. Speed is " + speed + " km/h");
            System.out.println("Apply brakes first.");
        } else {
            System.out.println("✅ Engine stopped.");
        }
    }

    @Override
    public void engineName() {
        System.out.println("Engine Name : " + engineName);
    }

    @Override
    public void brake() {
        speed -= 10;

        if(speed < 0){
            speed = 0;
        }

        System.out.println("Current Speed : " + speed);
    }

    @Override
    public void acc() {
        speed += 20;
        System.out.println("Current Speed : " + speed);
    }
}