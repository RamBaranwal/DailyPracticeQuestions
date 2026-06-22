package Oops2.ThisKeyWord;

public class ThisKeyWord {
    public static void main(String[] args) {
        Student kunal = new Student();
        System.out.println(kunal.name);
        Student kushwaha = new Student(10, "Kunal Kushwaha", 89.04);
        System.out.println(kushwaha.name);
        kushwaha.display();
        Student rahul = new Student(kushwaha);
        rahul.display();

        Student s1 = new Student(13, "Rishu", 67.8);
        Student s2 = s1;

        System.out.println(s2.name);
    }
}

class Student{
    int roll;
    String name;
    double marks;

    void display(){
        System.out.println("My name is " + this.name + " my roll call is " + this.roll + " this is my marks out of 100 -> " + this.marks);
    }

    // Student(){
    //     this.roll = 0;
    //     this.name = "null";
    //     this.marks = 0.00f;
    // }

    Student(){
        this(0, "by default not any name", 0.00f);
    }

    Student(int roll, String name, double marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    Student(Student other){
        this.roll = other.roll;
        this.name = other.name;
        this.marks = other.marks;
    }

}

