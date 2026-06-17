package Oops.Encapsulation.LearnPackage;

import java.util.Date;
import java.io.*;

public class Main {

    public String name;

    public Main(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Teaching obj = new Teaching();
        obj.email();

        obj.name = "Rohit";

        Teaching obj2 = new Teaching("Rohit Kumar");
    }
}

class Teaching {

    public String name;
    private String emailid;

    Teaching() {
        this.name = "nothing mentioned";
    }

    Teaching(String name) {
        this.name = name;
    }

    public void email() {
        System.out.println("your email is " + this.emailid);
    }
}