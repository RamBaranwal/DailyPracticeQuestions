import java.util.Arrays;

public class MakingClass {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        Student kunal;       // this is finding that is class present
        kunal = new Student(); // this is assign to referenced that that is the structure of the class
        System.out.println(kunal);  // give that it is referenced
        System.out.println(Arrays.toString(students));
        // now we create obj by first we used it as reference
        students[0] = new Student();
        System.out.println(Arrays.toString(students));

        // Output
        // Student@1dbd16a6
        // [null, null, null, null, null]
        // [Student@7ad041f3, null, null, null, null]
    }
}

class Student{
    int regNo;
    String name;
    void pass(int n){
        if(n > 33){
            System.out.println("Pass");
        }
        else{
            System.out.println("Failed");
        }
    }
}

