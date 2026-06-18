package Oops.Interface;

public class Interface {
    public static void main(String[] args) {
        Species sp1 = new Species();
        sp1.haveHand(4);
        sp1.haveLeg(2);
        sp1.havePaw(8);

        System.out.println(Human.sing);
    }
}

interface Human{
    // int hand;
    void haveHand(int hand);
    void haveLeg(int leg);

    // it is automatically become public static final 
    String sing = "human have voice for easy communication";

    // default help to not giving error to the other class if needed we use it by override on it
    // but it is compulsory to make the body of it 
    default void walk(){
        System.out.println("he/she is walking");
    }
}

interface Dog{
    void havePaw(int paw);
}

class Species implements Human, Dog{

    @Override
    public void haveHand(int hand){
        System.out.println("this is human extended class");
    }

    @Override
    public void haveLeg(int leg){
        System.out.println("this is human leg");
    }

    @Override
    public void havePaw(int paw){
        System.out.println("this is paw");
    }

    @Override
    public void walk(){
        System.out.println("Dog is walking");
    }
}
