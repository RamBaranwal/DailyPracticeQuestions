package Oops2.Inheritance;

// import Inheritance.Box;

public class Main {
    public static void main(String[] args) {
        Box obj = new Box();
        // private cannot be accessable
        //    ||
        //    \/
        // int length = obj.l;
        Box obj2 = new Box(5,4, 3);
        // here also cannot access the length because it is private
        // we only assign that at startign not access any where execpt its own class

        BoxWeight obj3 = new BoxWeight(5, 6, 7, 8.6f);
        // from child class we access the parent class variables and we also access the method of parent from child class
        System.out.println(obj2.w + " " + obj2.h); // cannot access the l because of private

        Box obj6 = new BoxWeight(5, 7, 6, 7.0f);
        System.out.println(obj6.w);
        // here we take Box as reference so can't able to access the child class things
        // System.out.println(obj6.weight);

        // BoxWeight obj7 = new Box(5, 4, 2);
        // cannot access parent class form child class

        BoxWeight obj8 = new BoxWeight((BoxWeight)obj6);

        BoxWeight obj9 = new BoxWeight(obj6);

        BoxPrice p1 = new BoxPrice(6, 9.0f, 3.5d);
    }
}
