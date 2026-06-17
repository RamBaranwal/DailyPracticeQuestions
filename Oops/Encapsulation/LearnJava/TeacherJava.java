package Oops.Encapsulation.LearnJava;

import Oops.Encapsulation.LearnPackage.Main;

public class TeacherJava {
    public static void main(String[] args) {

        Main obj = new Main("Roshani");
        String res = obj.name = "Rodahni";
        System.out.println(res);
    }
}