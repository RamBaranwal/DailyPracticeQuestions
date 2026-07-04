package Oops2.MiniInterfaceProject;

public interface Media {
    public void start();
    public void stop();
    public void resume();
    public void pause();
    public void next();
    public void previous();
    public void incVol();
    public void decVol();
    public String mediaType();
}
