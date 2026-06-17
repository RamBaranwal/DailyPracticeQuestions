package Oops.Encapsulation.LearnPackage;

public class TeachingClass {
    public String className;
    public int section;
    private int totalStudent;

    public static void main(String[] args) {
        Teaching obj = new Teaching();
        obj.name = "Rahul";
        // this is happens due to private of emailid due to not accessible 
        // obj.emailid;     
        obj.email();

    }
}
