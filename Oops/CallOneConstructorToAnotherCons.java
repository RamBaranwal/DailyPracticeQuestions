// Class = blueprint/template for creating objects
class Car {

    // =========================
    // INSTANCE VARIABLES
    // =========================
    // These variables belong to every object

    int model;
    String name;
    float price;


    // =========================
    // PARAMETERIZED CONSTRUCTOR
    // =========================
    // Runs automatically when object is created
    // Used to initialize object with custom values

    Car (int model, String name, float price){

        // this.model -> current object's instance variable
        // model      -> local parameter variable

        // storing parameter values into current object
        this.model = model;
        this.name = name;
        this.price = price;
    }


    // =========================
    // DISPLAY METHOD
    // =========================
    // Prints current object's data

    void display(){

        // this means current object

        System.out.println(this.model);
        System.out.println(this.name);
        System.out.println(this.price);
    }


    // =========================
    // DEFAULT CONSTRUCTOR
    // =========================

    // IMPORTANT:
    // When we create ANY constructor manually,
    // Java DOES NOT create default constructor automatically

    // So we manually created Car()

    Car(){

        // this(...)
        // calls another constructor of SAME class

        // internally calling:
        // Car(2026, "seden", 3500.0f)

        // this here means current object

        this (2026, "seden", 3500.0f);
    }
}


public class CallOneConstructorToAnotherCons {

    public static void main(String[] args) {

        // =========================
        // OBJECT CREATION
        // =========================

        // Calling default constructor
        Car c1 = new Car();

        /*
            FLOW:

            Step 1:
            new Car()

            Step 2:
            Car() constructor called

            Step 3:
            Inside Car():

            this(2026, "seden", 3500.0f);

            calls parameterized constructor

            Step 4:
            Parameterized constructor stores values

            model = 2026
            name  = seden
            price = 3500.0
        */


        // =========================
        // PRINT NAME
        // =========================

        System.out.println(c1.name);

        /*
            OUTPUT:
            seden
        */


        // =========================
        // MODIFY OBJECT DATA
        // =========================

        // changing current object's name
        c1.name = "SUV";


        // =========================
        // DISPLAY OBJECT DATA
        // =========================

        c1.display();

        /*
            OUTPUT:

            2026
            SUV
            3500.0
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
new Car() executes

STEP 3:
Default constructor Car() called

STEP 4:
Inside Car():

this(2026, "seden", 3500.0f);

calls parameterized constructor

STEP 5:
Parameterized constructor initializes object

STEP 6:
name printed -> seden

STEP 7:
name changed to SUV

STEP 8:
display() method prints updated values


========================================
IMPORTANT CONCEPTS
========================================


1. CLASS
---------
Blueprint/template for objects


2. OBJECT
----------
Real instance of class


3. INSTANCE VARIABLES
---------------------
Variables that belong to object

Example:

model
name
price


4. CONSTRUCTOR
--------------
Special method:
- Same name as class
- No return type
- Runs automatically during object creation


5. PARAMETERIZED CONSTRUCTOR
----------------------------
Constructor with parameters

Used for custom initialization


6. DEFAULT CONSTRUCTOR
----------------------
Constructor without parameters

Example:

Car()


7. IMPORTANT RULE
-----------------

If NO constructor is written:
Java creates default constructor automatically

BUT

If ANY constructor is written manually:
Java DOES NOT create default constructor


8. this KEYWORD
----------------
this means:

CURRENT OBJECT


9. this.variable
----------------

Example:

this.name

means:

current object's name variable


10. this(...)
----------------

Example:

this(2026, "seden", 3500.0f);

means:

call another constructor of SAME class


11. RULE OF this(...)
---------------------

this(...) must always be FIRST statement
inside constructor


Correct:

Car(){
    this(2026, "seden", 3500.0f);
}


Wrong:

Car(){
    System.out.println("Hello");
    this(2026, "seden", 3500.0f); // ERROR
}


========================================
MEMORY VISUALIZATION
========================================

c1  -----> Object

              model = 2026
              name  = SUV
              price = 3500.0


========================================
FINAL OUTPUT
========================================

seden
2026
SUV
3500.0


========================================
SUPER SHORT REVISION
========================================

new Car()

calls

Car()

Inside Car():

this(...)

calls another constructor


this.variable
=
current object's variable


this(...)
=
call another constructor of same class

*/