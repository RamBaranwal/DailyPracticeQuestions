package Oops.Polymorphism;
class Car{
    int year;
    String model;

    Car(String model, int year){
        this.model = model;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj){
        Car that = (Car)obj;
        if(this.model.equals(that.model) && this.year == that.year){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "this is car model " + this.model + " of year " + year;
    }
}

public class Main {

    public static void main(String[] args) {
        Car obj1 = new Car("Honda", 2026);
        Car obj2 = new Car("Honda", 2024);

        System.out.println(obj1.equals((Object)obj2));

        System.out.println(obj1);  // by default it will take .toString()
        System.out.println(obj2.toString());
    }

}