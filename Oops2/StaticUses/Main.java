package Oops2.StaticUses;

public class Main {
    public static void main(String[] args) {
        Human rahul = new Human("Rahul");
        Human karan = new Human("Karan", 15, false);

        karan.display();


        // we can access the population by the obj name like 
        // rahul.population and there is method i made 
        // not into uses but still we can use it by the obj name only not directly
        System.out.println(Human.population);
        long pop = Human.population;
        System.out.println(pop);

        greeting(rahul.name);
    }

    static void greeting(String name){
        System.out.println("hello " + name);
    }
}
