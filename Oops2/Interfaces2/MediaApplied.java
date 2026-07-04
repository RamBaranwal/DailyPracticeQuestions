package Oops2.Interfaces2;

/**
 * implement
 */
public class MediaApplied implements Media {

    private int forward = 10;
    private int backward = -10;

    public void nextTen(int forward){
        forward = this.forward;
        System.out.println("the video is now 10sec forwarded");
        forward += 10;
    }

    public void preTen(int backward){
        backward = this.backward;
        System.out.println("the video is now 10sec backward");
        backward += 10;
    }


    @Override
    public void start() {
        System.out.println("Music Started");
    }

    @Override
    public void stop() {
        System.out.println("Music Stopped");
    }

}
