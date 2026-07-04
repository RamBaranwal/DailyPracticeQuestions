package Oops2.Interfaces2;

public class RadioPlayer implements Media {

    @Override
    public void start() {
        System.out.println("Radio Started");
    }

    @Override
    public void stop() {
        System.out.println("Radio Stopped");
    }
}