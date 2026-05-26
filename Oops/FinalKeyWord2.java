public class FinalKeyWord2 {
    public static void main(String[] args) {

        // ========================================
        // FINAL WITH PRIMITIVE DATATYPES
        // ========================================

        // final means value cannot be reassigned

        // final variable must be initialized
        // final int num;

        final int num = 10;

        // ERROR:
        // once assigned, final variable cannot change

        // num = 20;


        // ========================================
        // NORMAL OBJECT REFERENCE
        // ========================================

        // object creation
        A stu1 = new A();

        /*
            FLOW:

            new A()

            calls default constructor

            A(){

                this(100000, "NA", 1.0f);

            }

            parameterized constructor called

            values stored:
            id = 100000
            name = NA
            pkg = 1.0
        */


        // display current object values
        stu1.display1();

        System.out.println();


        // changing object data
        // allowed because object reference is normal

        stu1.name = "Ram";
        stu1.pkg = 1000000.0f;


        // printing updated values
        stu1.display1();

        System.out.println();



        // ========================================
        // FINAL OBJECT REFERENCE
        // ========================================

        // stu2 reference is final

        final A stu2 = new A();

        /*
            IMPORTANT:

            final A stu2

            means:

            stu2 reference/address cannot change

            BUT

            object data CAN change
        */


        stu2.display2();

        System.out.println();


        // allowed:
        // changing object's internal data

        stu2.branch = "developer";


        stu2.display2();

        System.out.println();


        /*
            NOT ALLOWED:

            stu2 = new A();

            because final reference
            cannot point to another object
        */



        // ========================================
        // FINAL STRING
        // ========================================

        final String naam = "student";

        /*
            String is immutable

            concat() does NOT modify original string

            It creates NEW string
        */


        // NEW string created
        String naam3 = naam.concat("naam");

        System.out.println(naam3);

        System.out.println();

        /*
            naam still remains:
            "student"

            naam3 becomes:
            "studentnaam"
        */


        // ========================================
        // NORMAL STRING
        // ========================================

        String naam2 = "Student";

        /*
            here reassignment is allowed
        */

        naam2 = naam2.concat("naam2");

        System.out.println(naam2);

        System.out.println();



        // ========================================
        // STRINGBUILDER
        // ========================================

        /*
            StringBuilder is mutable

            mutable means:
            original object CAN change
        */

        StringBuilder sb = new StringBuilder("Hello");


        // modifies SAME object
        sb.append(" World");

        System.out.println(sb);

        System.out.println();


        /*
            reassignment allowed because
            sb is not final
        */

        sb = new StringBuilder("New");

        System.out.println(sb);

        System.out.println();



        // ========================================
        // FINAL STRINGBUILDER
        // ========================================

        final StringBuilder sb2 = new StringBuilder("Hello");


        // allowed:
        // changing internal object data

        sb2.append(" World");


        /*
            ERROR:

            sb2 = new StringBuilder("New");

            because final reference
            cannot point to another object
        */
    }
}



// ========================================
// CLASS A
// ========================================

class A{

    // instance variables
    int id;
    String name;

    // package is reserved keyword
    // so using pkg
    float pkg;

    String branch;



    // ========================================
    // DISPLAY METHOD 1
    // ========================================

    void display1(){

        System.out.println(this.id);
        System.out.println(name);
        System.out.println(pkg);
    }



    // ========================================
    // DISPLAY METHOD 2
    // ========================================

    void display2(){

        System.out.println(this.id);
        System.out.println(name);
        System.out.println(pkg);
        System.out.println(this.branch);
    }



    // ========================================
    // DEFAULT CONSTRUCTOR
    // ========================================

    /*
        this()

        calls another constructor
        of same class
    */

    A(){

        // constructor chaining
        this(100000, "NA", 1.0f);
    }



    // ========================================
    // PARAMETERIZED CONSTRUCTOR
    // ========================================

    A(int id, String name, float pkg){

        // this.id -> current object's variable
        // id      -> local parameter

        this.id = id;
        this.name = name;
        this.pkg = pkg;
    }



    // ========================================
    // PARAMETERIZED CONSTRUCTOR WITH BRANCH
    // ========================================

    A(int id, String name, float pkg, String branch){

        this.id = id;
        this.name = name;
        this.pkg = pkg;
        this.branch = branch;
    }
}



/*

====================================================
COMPLETE FLOW OF PROGRAM
====================================================

STEP 1:
main() starts


STEP 2:
final primitive variable created

final int num = 10;

num cannot change later


STEP 3:
stu1 object created

default constructor called

inside default constructor:

this(100000, "NA", 1.0f);

calls parameterized constructor


STEP 4:
stu1 values printed


STEP 5:
stu1 object data modified

name = Ram
pkg  = 1000000.0


STEP 6:
updated values printed


STEP 7:
final object reference stu2 created

reference cannot change

BUT object data can change


STEP 8:
branch changed to developer


STEP 9:
final String example

String immutable
concat() creates NEW string


STEP 10:
normal String reassignment


STEP 11:
StringBuilder example

mutable object
append() modifies same object


STEP 12:
final StringBuilder example

object data can change
reference cannot change


====================================================
MOST IMPORTANT CONCEPTS
====================================================


1. final PRIMITIVE
-------------------

final int num = 10;

num = 20; // ERROR

Value cannot change


====================================================


2. final OBJECT REFERENCE
--------------------------

final A stu2 = new A();

means:

reference/address cannot change


Allowed:
stu2.name = "Ram";

Not Allowed:
stu2 = new A();


====================================================


3. IMMUTABLE OBJECT
-------------------

String is immutable

Cannot modify original object


Example:

String s = "Hello";

s.concat("World");

Original string unchanged


====================================================


4. MUTABLE OBJECT
-----------------

StringBuilder is mutable

Original object changes


Example:

sb.append("World");

modifies same object


====================================================


5. this KEYWORD
----------------

this.variable

means:

current object's variable


====================================================


6. this(...)
------------

calls another constructor
of same class


====================================================


7. IMPORTANT RULE
------------------

this(...) must always
be first statement inside constructor


====================================================
MEMORY VISUALIZATION
====================================================


NORMAL OBJECT
-------------

stu1 -----> Object


FINAL OBJECT REFERENCE
----------------------

stu2 -----> Object

Reference fixed

BUT data inside object can change


====================================================
FINAL OUTPUT
====================================================

100000
NA
1.0

100000
Ram
1000000.0

100000
NA
1.0
null

100000
NA
1.0
developer

studentnaam

Studentnaam2

Hello World

New


====================================================
SUPER SHORT REVISION
====================================================

final primitive
=
value cannot change


final object
=
reference cannot change


String
=
immutable


StringBuilder
=
mutable


this.variable
=
current object's variable


this(...)
=
call another constructor

*/

