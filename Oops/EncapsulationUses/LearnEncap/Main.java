package Oops.EncapsulationUses.LearnEncap;

import Oops.EncapsulationUses.LearnEncapHiding.Teacher;
import Oops.EncapsulationUses.LearnEncapHiding.Student;

public class Main {
    public static void main(String[] args){
        Teacher obj = new Teacher();
        // obj.name;  // not accessible due to private 
        obj.school = "Sunbeam";
        // this is accessible due to public 

        obj.setName("Roshani");
        String res = obj.getName();
        System.out.println(res);

        Student s1 = new Student();
        s1.setAge(-10);
        // System.out.println(s1.getAge());

    }

}
