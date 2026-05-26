// Class = blueprint/template for creating objects
class Car {

    // Instance variables (data members of object)
    int model;
    String name;
    float price;

    // Method to display object data
    void display() {

        // Prints current object's model
        System.out.println(model);

        // this.name -> current object's name
        System.out.println(this.name);

        // this.price -> current object's price
        System.out.println(this.price);

        System.out.println();
    }

    // Parameterized Constructor
    // Automatically called during object creation
    // we provide some value to the model into the main class so it locale it
    Car(int model, String name, float price) {

        // Left side = instance/global variable
        // Right side = local variable/parameter

        this.model = model;
        this.name = name;
        this.price = price;
    }

    // Copy Constructor
    // Copies data from another object
    Car(Car c) {

        // this = current object
        // c = object passed as argument

        // Copying values from c object
        this.model = c.model;
        this.name = c.name;
        this.price = c.price;
    }
}

public class TakingOtherObjToPresentObj {

    public static void main(String[] args) {

        // =========================
        // OBJECT CREATION
        // =========================

        // new object created
        // parameterized constructor called
        Car c1 = new Car(2026, "Tesla", 45.5f);

        /*
            c1 Object

            model = 2026
            name  = Tesla
            price = 45.5
        */


        // =========================
        // COPY CONSTRUCTOR
        // =========================

        // New object created separately
        // Data copied from c1 to c2
        Car c2 = new Car(c1);

        /*
            c2 Object

            model = 2026
            name  = Tesla
            price = 45.5

            NOTE:
            c1 and c2 are DIFFERENT objects
        */


        // =========================
        // REFERENCE COPY
        // =========================

        // NO new object created

        // c3 stores same reference/address as c1

        // Both point to SAME object
        Car c3 = c1;

        /*
                c1 --------\
                              ---> SAME OBJECT
                c3 --------/

                model = 2026
                name  = Tesla
                price = 45.5
        */


        // =========================
        // DISPLAY BEFORE CHANGES
        // =========================

        System.out.println("c1 Data:");
        c1.display();

        System.out.println("c2 Data:");
        c2.display();

        System.out.println("c3 Data:");
        c3.display();


        // =========================
        // MODIFY USING c3
        // =========================

        // Changing data using c3 reference
        c3.name = "BMW";

        /*
            Since c3 and c1 point to SAME object,

            c1.name also becomes BMW
        */


        // =========================
        // DISPLAY AFTER CHANGES
        // =========================

        System.out.println("After Changing c3.name = BMW");

        System.out.println("c1 Data:");
        c1.display();

        System.out.println("c2 Data:");
        c2.display();

        System.out.println("c3 Data:");
        c3.display();

        /*
            OUTPUT EXPLANATION

            c1 and c3 changed because
            both point to SAME object

            c2 unchanged because
            copy constructor created
            separate object
        */
    }
}

/*

========================================
COMPLETE FLOW OF PROGRAM
========================================

STEP 1:
main() starts

STEP 2:
c1 object created

STEP 3:
Parameterized constructor runs

STEP 4:
Values stored inside c1

STEP 5:
c2 object created

STEP 6:
Copy constructor runs

STEP 7:
Data copied from c1 -> c2

STEP 8:
c3 = c1

No new object created
Only reference copied

STEP 9:
display() methods print values

STEP 10:
c3.name changed to BMW

STEP 11:
Since c3 and c1 point to same object,
both show BMW

STEP 12:
c2 remains unchanged
because it is separate object


========================================
VERY IMPORTANT DIFFERENCE
========================================

1. COPY CONSTRUCTOR
-------------------

Car c2 = new Car(c1);

- New object created
- Data copied
- Independent objects

Memory:

c1 ---> Object 1
c2 ---> Object 2


2. REFERENCE COPY
-----------------

Car c3 = c1;

- No new object
- Same reference copied
- Both variables point to same object

Memory:

c1 --------\
             ---> SAME OBJECT
c3 --------/


========================================
this KEYWORD
========================================

this.variable

means:

current object's variable


========================================
CONSTRUCTOR
========================================

- Same name as class
- No return type
- Runs automatically during object creation


========================================
new KEYWORD
========================================

- Allocates memory
- Creates object
- Calls constructor


========================================
FINAL REVISION SUMMARY
========================================

Car c2 = new Car(c1);

=> Separate object created


Car c3 = c1;

=> Same object reference copied


Changing c3 affects c1
because both point to same object


Changing c2 does NOT affect c1
because both are different objects

*/