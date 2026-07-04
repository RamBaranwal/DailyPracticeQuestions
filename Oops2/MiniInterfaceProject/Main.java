package Oops2.MiniInterfaceProject;

public class Main {

    public static void main(String[] args) {

        // ================= CREATE OBJECTS =================

        Engine petrolEngine = new PetroleEngine();
        Engine electricEngine = new ElectricEngine();

        Media musicPlayer = new MusicPlayer();
        Media radioPlayer = new RadioPlayer();

        // Car initially has Petrol Engine and Music Player
        Car car = new Car(petrolEngine, musicPlayer);

        // ==================================================
        System.out.println("\n===== INITIAL DASHBOARD =====");
        car.dashboard();

        // ==================================================
        System.out.println("\n===== TRY WITHOUT STARTING ENGINE =====");

        car.accelerate();
        car.startMusic();

        // ==================================================
        System.out.println("\n===== START ENGINE =====");

        car.startEngine();
        car.startEngine();     // Already running

        // ==================================================
        System.out.println("\n===== MUSIC PLAYER =====");

        car.startMusic();
        car.increaseVol();
        car.increaseVol();

        car.nextSongOrNextFrequency();
        car.nextSongOrNextFrequency();

        car.previousSongOrPreviousFrequency();

        car.pauseMusic();
        car.resumeMusic();

        // ==================================================
        System.out.println("\n===== DRIVING =====");

        car.accelerate();
        car.accelerate();
        car.accelerate();

        car.brake();
        car.brake();

        car.dashboard();

        // ==================================================
        System.out.println("\n===== TRY TO CHANGE ENGINE WHILE MOVING =====");

        car.changeEngine(electricEngine);

        // ==================================================
        System.out.println("\n===== STOP THE CAR =====");

        car.brake();
        car.brake();
        // car.brake();
        // car.brake();
        car.emergencyBrake();

        // ==================================================
        System.out.println("\n===== CHANGE ENGINE =====");

        // car.stopEngine();

        car.changeEngine(electricEngine);
        
        car.stopEngine();
        car.changeEngine(electricEngine);

        car.dashboard();

        // ==================================================
        System.out.println("\n===== START ELECTRIC ENGINE =====");

        car.startEngine();

        car.accelerate();
        car.accelerate();

        // ==================================================
        System.out.println("\n===== CHANGE MEDIA =====");

        car.changeMedia(radioPlayer);

        car.startMusic();

        car.nextSongOrNextFrequency();
        car.nextSongOrNextFrequency();

        car.increaseVol();
        car.decreaseVol();

        // ==================================================
        System.out.println("\n===== FINAL DASHBOARD =====");

        car.dashboard();

        // ==================================================
        System.out.println("\n===== SHUTDOWN =====");

        while (car.getSpeed() > 0) {
            car.brake();
        }

        car.stopMusic();
        car.stopEngine();

        // ==================================================
        System.out.println("\n===== END OF SIMULATION =====");
    }
}