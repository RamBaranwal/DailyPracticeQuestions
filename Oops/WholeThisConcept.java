class Car{
    int model;
    String name;
    float price;

    // default constructor is already present
    // if i make a object and print the values to
    // access the model, name, price it will give

    // output -> for model => 0,,, for name => null,,, for price => 0.0

    // but now want if some empty object come not show above values it will show what we want
    // create default constructor of same class name

    Car () {
        // we may use this and not this it is for good practice
        // its real roll comes into the parameterized constructor
        this.model = 2001;
        // because all car start manufactured from 2001
        // if there is no any value by default it will take 2001

        this.name = "Saden";
        this.price = 0.1f;

    }

    // now parameterized constructor
    Car(int model, String name, float price){
        this.model = model;
        // here the first model with this is refer to the class defined
        // and after the equals to this is locally defined model
        // to diffenercicate we use this other wise
        // if we make any obj and assigned some value to it
        // and call it then it will return us default one

        this.name = name;
        this.price = price;
        // there is other method also to by pass it
        // change the local variable name it goes smoothly without this
        //  but as coder number of variables confused the lines

    }

    Car(String brand, float value, int designed){
        model = designed;
        name = brand;
        price = value;
    }

}
public class WholeThisConcept {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1.name);  // default values called
    }
}
