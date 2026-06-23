package Oops2.StaticUses.StaticProperties;

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

        // we cannot call non-static method or variable from static class so we
        // have to firstly make its instance then call it
        // see from which obj it is belong then use it

        Main.fun(rahul.name);
        // we can do both
        System.out.println();
        fun(karan.name);
    }

    static void fun(String name){
        Main obj = new Main();
        obj.greeting(name);
        System.out.println("by static calling we create an obj then we run fun2 but previously it is run through greeting which already non-static so no need of obj creation");
        obj.fun2();
    }


    void greeting(String name){
        System.out.println("hello " + name);
        fun2();
    }

    // not need of the obj creation because it run through non-static so we don't need
    // of that we can simply use it but if
    // we use it trough the fun we have to create its obj for run
    void fun2(){
        System.out.println("hello ji kaise hai aap");
    }
}
