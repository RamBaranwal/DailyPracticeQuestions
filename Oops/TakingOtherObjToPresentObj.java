class Car {
    int model;
    String name;
    float price;

    void display() {
        System.out.println(model);
        System.out.println(this.name);
        System.out.println(this.price);
    }

    Car(int model, String name, float price) {
        this.model = model;
        this.name = name;
        this.price = price;
    }

    Car(Car c) {
        // this is global access and
        // c is loacal access the model
        this.model = c.model;
        this.name = c.name;
        this.price = c.price;
    }
}

public class TakingOtherObjToPresentObj {

    public static void main(String[] args) {
        Car c1 = new Car(2026, "Tesla", 45.5f);
        Car c2 = new Car(c1);

        c1.display();
        c2.display();
    }
}

// output
// 2026
// Tesla
// 45.5
// 2026
// Tesla
// 45.5