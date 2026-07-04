package Oops2.MiniInterfaceProject;

public class Car {
    private Engine engine;
    private Media media;
    private int speed = 0;
    private boolean engineRunning = false;

    Car(Engine engine, Media media) {
        this.engine = engine;
        this.media = media;
    }

    // ================= Engine =====================
    public void startEngine() {
        if (engineRunning) {
            System.out.println("Engine is already running");
            return;
        }
        engineRunning = true;
        engine.start();
    }

    public void stopEngine() {
        if (speed != 0) {
            System.out.println("Speed is not zero");
            return;
        }
        if (!engineRunning) {
            System.out.println("Already stopped");
            return;
        }
        engine.stop();
        media.stop();
        engineRunning = false;
    }

    public void accelerate() {
        if (!engineRunning) {
            System.out.println("Start Engine first");
            return;
        }
        engine.acc();
        speed += 20;
        System.out.println("Current speed " + speed + " km/hr");
    }

    public void brake() {
        if (speed == 0) {
            System.out.println("Already Stopped");
            return;
        }
        engine.brake();
        if (speed >= 10) {
            speed -= 10;
        }
        System.out.println("Current speed " + speed + " km/hr");
    }

    public int getSpeed() {
        return speed;
    }

    public void emergencyBrake(){
        System.out.println("Emergency Brake is applied");
        speed = 0;
        System.out.println("Current speed " + speed + " km/hr");
    }

    // ===================== Media ========================
    public void startMusic() {
        if (!engineRunning) {
            System.out.println("Firstly start Engine");
            return;
        }
        media.start();
    }

    public void stopMusic() {
        media.stop();
    }

    public void resumeMusic() {
        media.resume();
    }

    public void pauseMusic() {
        media.pause();
    }

    public void nextSongOrNextFrequency() {
        media.next();
    }

    public void previousSongOrPreviousFrequency() {
        media.previous();
    }

    public void increaseVol() {
        media.incVol();
    }

    public void decreaseVol() {
        media.decVol();
    }

    // =================== change engine =========================
    public void changeEngine(Engine engine) {
        if (speed != 0) {
            System.out.println("Firstly make speed 0 to change the engine");
            return;
        }
        if(engineRunning){
            System.out.println("Firstly stop the engine");
            return;
        }
        this.engine = engine;
        System.out.println("==================================");
        System.out.println("Changing engine successfully done");
        System.out.println("Current Engine: " + engine.engineType());
        System.out.println("==================================");
    }

    // =================== change media ==========================
    public void changeMedia(Media media) {
        this.media = media;
        System.out.println("===================================");
        System.out.println("Changing media done successfully");
        System.out.println("Changing Media " + media.mediaType());
        System.out.println("===================================");
    }

    // ====================== dashboard ===========================
    public void dashboard() {
        System.out.println("============== DASHBOARD ================");
        System.out.println("Media player is used " + media.mediaType());
        System.out.println("Engine is used " + engine.engineType());
        if(engineRunning){
            System.out.println("Engine is Running");
        }
        else{
            System.out.println("Engine is not Running");
        }
        System.out.println("Current speed is " + speed + " km/hr");
        System.out.println("=========================================");
    }
}
