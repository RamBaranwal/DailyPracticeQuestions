package Oops2.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW");
        car1.engineName();
        car1.start();
        car1.acc();
        car1.acc();
        car1.brake();
        
        car1.stop();

        System.out.println(car1.b);
        System.out.println(car1.a);

        Engine eng1 = new Car("Audi");
        // so Engine is parent it is not able to see the child class things so not able to access the b variable
        // eng1.acc(); // same not accesscible because it is engineproperties not present into engine
        


        /*  System.out.println(eng1.b); */
        System.out.println(eng1.a);
    }
}
