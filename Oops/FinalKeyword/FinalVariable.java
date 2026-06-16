package FinalKeyword;

public class FinalVariable {
    public static void main(String[] args) {

        final int age = 20;

        // age = 30;   // ERROR
        System.out.println(age);
        // cannot assign a value to final variable age

        Student s = new Student(101);
        s.print();
    }
}

class Test {

    final int x;

    Test() {
        x = 10;
        // x = 20; // ERROR
    }

    void print(final int x) {

        System.out.println(x);

        // x = 70; // ERROR
        // final parameter x may not be assigned
    }
}

class Student {

    final int rollNo;

    String name;
    Student(int rollNo) {
        this.rollNo = rollNo;
        // this.rollNo = 200; // ERROR
    }

    void print() {
        System.out.println(rollNo);
    }

    Student(String name){
        this.rollNo = 0;
        this.name = name;
    }
}


class Vehicle {
    // final method
    final void start() {
        System.out.println("Vehicle Started");
    }
}

// final class 
final class Subject {
    // The type Car cannot subclass the final class Vehicle
}