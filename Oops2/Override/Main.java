package Oops2.Override;

public class Main {
    public static void main(String[] args) {
        Overriden obj = new Overriden("Rohan");
        System.out.println(obj.toString());
        System.out.println(obj.hashCode());
        System.out.println(obj.getClass().getConstructors());
    }
}
