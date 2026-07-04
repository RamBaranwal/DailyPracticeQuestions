package Oops2.Abstract;

/**
 * Parent
 */
// class is not be final because it have to be inherited
public abstract class Parent {
    int age;
    String name;
    boolean marriage;
    // to use the Parent constructor value we make this

    Parent(){

    }
    Parent(int age){
        this.age = age;
    }

    static void hello(){
        System.out.println("hey");
    }

    static int num = 9;
    
    public void career(){
        System.out.println("i want to be a " + name);
    }

    abstract boolean haveMarriage(boolean done);

    final int call = 4;
    // call = 4;
}