package Oops2.Override;

public class Overriden {
    String name;

    Overriden(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
    
}
