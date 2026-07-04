package Oops2.Interfaces2;

public class Car {

    private Engine engine;
    private Media media;

    public Car(Engine engine, Media media) {
        this.engine = engine;
        this.media = media;
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public void accelerate() {
        engine.acc();
    }

    public void startMusic() {
        media.start();
    }

    public void stopMusic() {
        media.stop();
    }
}
