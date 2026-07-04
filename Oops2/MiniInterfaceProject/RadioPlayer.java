package Oops2.MiniInterfaceProject;

public class RadioPlayer implements Media{

    private int vol = 50;
    private float currFre = 98.2f;

    @Override
    public void start() {
        System.out.println("Radio Player is Started");
    }

    @Override
    public void stop() {
        System.out.println("Radio player is Stopped");
    }

    @Override
    public void resume() {
        System.out.println("Radio Player Unmuted");
    }

    @Override
    public void pause() {
        System.out.println("Radio Player Muted");
    }

    @Override
    public void next() {
        currFre += 0.2f;
        System.out.println("Current Frequency is " + currFre);
    }

    @Override
    public void previous() {
        currFre -= 0.2f;
        System.out.println("Current Frequency is " + currFre);
    }

    @Override
    public void incVol() {
        if(vol < 100){
            vol += 10;
        }
        System.out.println("Volume " + vol);
    }

    @Override
    public void decVol() {
        if(vol > 0){
            vol -= 10;
        }
        System.out.println("Volume " + vol);
    }

    @Override
    public String mediaType() {
        return "Radio Player";
    }
    
}
