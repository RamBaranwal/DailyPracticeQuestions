class Car {

    // Instance variables
    // Every object of Car will have its own copy of these variables
    int model;
    String name;
    float price;

    // =========================================================
    // DEFAULT / NO-ARGUMENT CONSTRUCTOR
    // =========================================================

    /*
     * If we do not create any constructor,
     * Java automatically provides one:
     * 
     * Car() { }
     * 
     * But once we create our own constructor,
     * Java stops creating the automatic constructor.
     * 
     * This constructor is used when object is created
     * without passing any values.
     * 
     * Purpose:
     * -> Assign custom default values
     * -> Avoid showing Java default values
     * 
     * Java default values:
     * int -> 0
     * String -> null
     * float -> 0.0
     */

    Car() {

        /*
         * "this" refers to current object.
         * 
         * this.model means:
         * -> current object's model variable
         */

        this.model = 2001;

        /*
         * Suppose every car starts manufacturing
         * from year 2001 by default
         */

        this.name = "Sedan";

        // default price if no value is provided
        this.price = 0.1f;
    }

    // =========================================================
    // PARAMETERIZED CONSTRUCTOR
    // =========================================================

    /*
     * Used when we want different values
     * for different objects during object creation.
     * 
     * Here constructor parameters and instance variables
     * have same names.
     * 
     * So we use "this" keyword to differentiate.
     */

    Car(int model, String name, float price) {

        /*
         * Left side -> instance variable
         * Right side -> local constructor parameter
         * 
         * Without "this":
         * 
         * model = model;
         * 
         * Java gets confused and local variable
         * assigns value to itself only.
         * 
         * Instance variable remains unchanged.
         */

        this.model = model;
        this.name = name;
        this.price = price;
    }

    // =========================================================
    // ANOTHER PARAMETERIZED CONSTRUCTOR
    // =========================================================

    /*
     * Here parameter names are different
     * from instance variables.
     * 
     * So "this" keyword is optional.
     */

    Car(String brand, float value, int designed) {

        model = designed;
        name = brand;
        price = value;
    }

    // =========================================================
    // DISPLAY METHOD
    // =========================================================

    /*
     * Method used to print object details
     */

    void display() {

        System.out.println("Model : " + this.model);
        System.out.println("Name  : " + name);
        System.out.println("Price : " + price);

        System.out.println();
    }
}

// =========================================================
// MAIN CLASS
// =========================================================

public class UpgradedWholeThisConcept {

    public static void main(String[] args) {

        // =====================================================
        // OBJECT 1
        // =====================================================

        /*
         * Calls no-argument constructor
         * 
         * Since no values are passed,
         * object gets custom default values
         */

        Car c1 = new Car();

        // =====================================================
        // OBJECT 2
        // =====================================================

        /*
         * Calls parameterized constructor
         * 
         * Values passed directly during object creation
         */

        Car c2 = new Car(2024, "BMW", 4500000f);

        // =====================================================
        // OBJECT 3
        // =====================================================

        /*
         * Calls second parameterized constructor
         */

        Car c3 = new Car("Audi", 5500000f, 2025);

        // =====================================================
        // PRINTING OBJECT DETAILS
        // =====================================================

        System.out.println("Car 1 Details:");
        c1.display();

        System.out.println("Car 2 Details:");
        c2.display();

        System.out.println("Car 3 Details:");
        c3.display();
    }
}

/*


======================== OUTPUT ========================

Car 1 Details:
Model : 2001
Name  : Sedan
Price : 0.1


Car 2 Details:
Model : 2024
Name  : BMW
Price : 4500000.0


Car 3 Details:
Model : 2025
Name  : Audi
Price : 5500000.0



======================== IMPORTANT NOTE ========================

If NO constructor is created:

class Car {
    int model;
    String name;
    float price;
}

Then output becomes:

Model : 0
Name  : null
Price : 0.0

Because Java automatically assigns default values.


======================== WHY THIS KEYWORD ========================

Correct:

    this.model = model;

Wrong:

    model = model;

Reason:
-> local variable assigns value to itself
-> instance variable remains unchanged


======================== MEMORY TRICK ========================

this.variable = variable;

LEFT  SIDE -> instance variable
RIGHT SIDE -> local variable


===============================================================

*/