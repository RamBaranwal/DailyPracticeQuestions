package Oops2.MiniInterfaceProject;

public class ElectricEngine implements Engine {

    private int battery = 100;

    @Override
    public void start() {
        System.out.println("Electric engine is started");
    }

    @Override
    public void stop() {
        System.out.println("Electric engine is stopped");
    }

    @Override
    public void acc() {
        if(battery > 0){
            battery--;
            System.out.println("Electric engine battery is " + battery + " %");
            System.out.println("Electric engine is using acceleration");
        }
        else{
            System.out.println("Electric engine is Out of fuel");
        }
        
    }

    @Override
    public void brake() {
        System.out.println("Electric engine is using brake");
    }

    @Override
    public String engineType() {
        return "Electric Engine";
    }

}
