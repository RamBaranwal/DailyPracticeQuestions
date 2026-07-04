package Oops2.Abstract.InheritanceOfAbstractClass;

abstract class Animal {

    abstract void sound();

    void eat() {
        System.out.println("Animal is eating");
    }
}

abstract class Mammal extends Animal {

    abstract void walk();

    void sleep() {
        System.out.println("Mammal is sleeping");
    }
}

class Dog extends Mammal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    @Override
    void walk() {
        System.out.println("Dog walks on four legs");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
        d.walk();
        d.eat();
        d.sleep();
    }
}
