package Oops2.StaticUses.StaticProperties;

public class Human {
    String name;
    int age;
    boolean marrige;
    static long population;

    Human(String name){
        this.name = name;
        Human.population += 1;
    }

    Human(String name, int age, boolean marrige){
        this.name = name;
        this.age = age;
        this.marrige = marrige;
        Human.population += 1;
    }

    void totalPopulation(){
        System.out.println(Human.population);
    }

    void display(){
        String merr;
        if(this.marrige){
            merr = "marrige";
        }
        else{
            merr = "not marrige";
        }
        System.out.println("Name is " + this.name + " age is " + this.age + " i am " + merr);
    }
}
