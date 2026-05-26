public class MakingClassWithArray {
     public static void main(String[] args) {

        Student[] students = new Student[2];

        students[0] = new Student();
        students[1] = new Student();

        students[0].name = "Ram";
        students[0].regNo = 1;

        students[1].name = "Shyam";
        students[1].regNo = 2;

        System.out.println(students[0].name);
        System.out.println(students[1].name);
    }
}
class Student {
    int regNo;
    String name;
}