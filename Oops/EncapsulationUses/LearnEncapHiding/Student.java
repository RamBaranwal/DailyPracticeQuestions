package Oops.EncapsulationUses.LearnEncapHiding;

public class Student {

    private int age;

    // public Student(int age){

    //     if(age > 0){
    //         this.age = age;
    //     }
    //     else{
    //         System.out.println("Invalid Age");
    //         this.age = 18;   // default value
    //     }
    // }

    // public Student(int age){

    //     if(age <= 0){
    //         throw new IllegalArgumentException("Age must be positive");
    //     }

    //     this.age = age;
    // }

    // this is that we play with the constructor 

    public void setAge(int age){

        if(age > 0 && age <= 100){
            this.age = age;
        }else{
            System.out.println("Invalid Age");
        }
    }


    public int getAge(){
        return age;
    }
}