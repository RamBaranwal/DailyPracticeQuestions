package Oops2.PackagesAccess.PackB;

public class Greeting {
    String name;

    public Greeting(String name) {
        this.name = name;
    }

    public Greeting(){
        this.name = "XYZ";
    }

    public void message() {
        System.out.println("Hello my name is " + this.name);
    }
}