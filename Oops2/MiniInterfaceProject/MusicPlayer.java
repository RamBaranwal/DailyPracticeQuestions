package Oops2.MiniInterfaceProject;

public class MusicPlayer implements Media {

    private int vol = 50;
    private int currentSong = 1;
    private boolean play = false;

    @Override
    public void start() {
        play = true;
        System.out.println("Music Player is Started");
    }

    @Override
    public void stop() {
        play = false;
        System.out.println("Music player is Stopped");
    }

    @Override
    public void resume() {
        if(!play){
            play = true;
            System.out.println("Music Player Resumed");
        }
        else{
            System.out.println("Music Player is already running");
        }
    }

    @Override
    public void pause() {
        if(play){
            play = false;
            System.out.println("Music Player Paused");
        }
        else{
            System.out.println("Music Player is already paused");
        }
    }

    @Override
    public void next() {
        currentSong += 1;
        System.out.println("Current Song is " + currentSong);
    }

    @Override
    public void previous() {
        if(currentSong > 1){
            currentSong--;
        }
        System.out.println("Current song is " + currentSong);
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
        return "Media Player";
    }
    
}
