package Oops2.Interfaces2;

public class Main {

    public static void main(String[] args) {

        Engine engine = new PetrolEngine();

        Media media = new MediaApplied();

        Car car = new Car(engine, media);

        car.startEngine();

        car.accelerate();

        car.startMusic();

        car.stopMusic();

        car.stopEngine();
    }
}
