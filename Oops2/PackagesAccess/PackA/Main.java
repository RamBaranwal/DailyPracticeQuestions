package Oops2.PackagesAccess.PackA;

// import java.util.ArrayList;

import Oops2.PackagesAccess.PackB.Greeting;

public class Main {
    public static void main(String[] args) {

        Greeting obj = new Greeting("Ram");

        // ArrayList<Integer> res = new ArrayList<>();

        Greeting obj2 = new Greeting();

        obj.message();
        obj2.message();
    }
}
