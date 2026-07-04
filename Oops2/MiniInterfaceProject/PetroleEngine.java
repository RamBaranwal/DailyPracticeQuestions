package Oops2.MiniInterfaceProject;

public class PetroleEngine implements Engine{

    private int fuel = 100;

    @Override
    public void start() {
        System.out.println("Petrol engine is started");
    }

    @Override
    public void stop() {
        System.out.println("Petrol engine is stopped");
    }

    @Override
    public void acc() {
        if(fuel > 0){
            fuel -= 2;
            System.out.println("Petrol engine fuel is " + fuel + " %");
            System.out.println("Petrol engine is using acceleration");
        }
        else{
            System.out.println("Petrol engine is Out of fuel");
        }
        
    }

    @Override
    public void brake() {
        System.out.println("Petrol engine is using brake");
    }

    @Override
    public String engineType() {
        return "Petrol Engine";
    }
}
