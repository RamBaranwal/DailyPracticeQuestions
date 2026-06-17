package Oops.EncapsulationUses.LearnEncapHiding;

public class Teacher {
    private String name;
    // now this is not accessible by any one out side this class

    public String school;
    // now this is accessible by any class or sub class or package

    // private boolean flag = false;
    // private boolean flag2 = true;
    public void setName(String name){

        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else{
            System.out.println("Invalid Name");
        }
    }

    public String getName(){
        return name;
    }
}
