class Student {
    int regNo;
    String name;
    float marks;

    String passOrFail(float marks){
        if(marks < 33.00){
            return "Failed";
        }
        return "Passed";
    }
    
    Student() {
        // this basically replace the obj like here s2 done
        // if some other called it replace that also
        this.regNo = 0;
        this.name = "Unkown";
        this.marks = 0.0f;
    }
}
public class ThisKeyWord {
    public static void main(String[] args) {

        // the problem is for each we have to write it again and again so we use
        // constructor is now coming into role
        // here we just integrate values number or lines of code extends but do same work

        // now s1 is using default because till here it is empty
        Student s1 = new Student();
        System.out.println(s1.name);
        // s1 is not using default constructor because it have some value
        s1.regNo = 1;
        s1.name = "Hello";
        s1.marks = 98f;

        String res = s1.passOrFail(s1.marks);
        System.out.println(s1.name + " is " + res);

        System.out.println(s1.regNo);
        System.out.println(s1.name);
        System.out.println(s1.marks);

        // as if someone make new obj but not assign any value so here the default values
        // that we specially assign comes

        Student s2 = new Student();
        System.out.println(s2.regNo);
        System.out.println(s2.name);
        System.out.println(s2.marks);

    }
    
}