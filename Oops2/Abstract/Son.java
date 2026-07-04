package Oops2.Abstract;

public class Son extends Parent {

    // if we remove the default constructor from the abstract class we have to make the constructor into
    // the extended class we have to define it because it help to make it
    // if we are not make the constructor after removing it we face issue to make the obj

    int age = 60;
    Son(int age){
        super(age);
    }
    
    void greeting(){
        System.out.println("say hi to " + name);
    }

    @Override
    boolean haveMarriage (boolean done){
        return done;
    }

    Parent obj = new Parent() {
        @Override
        boolean haveMarriage(boolean done) {
            return done;
        }
    };
}
