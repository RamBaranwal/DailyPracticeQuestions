public class FinalKeyWord {
    public static void main(String[] args) {
        // when we create it we have to initialized it
        // final int num = 10;
        // num = 20;

        A stu1 = new A();
        stu1.display1();
        System.out.println();
        stu1.name = "Ram";
        stu1.pkg = 1000000.0f;
        stu1.display1();
        System.out.println();

        final A stu2 = new A();
        stu2.display2();
        System.out.println();
        // we can change the value because here obj is not finallized here
        // stu2 is finalized now we cannot chnage the refrence address
        stu2.branch = "developer";
        stu2.display2();
        System.out.println();

        final String naam = "student";
        // i assign new String to run but
        // if i am storing into same naam then it will create error due to final
        String naam3 = naam.concat("naam");
        System.out.println(naam3);
        System.out.println();

        String naam2 = "Student";
        naam2 = naam2.concat("naam2");
        System.out.println(naam2);

        // some examples
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");
        System.out.println(sb);
        System.out.println();
        sb = new StringBuilder("New");

        System.out.println(sb);
        System.out.println();

        final StringBuilder sb2 = new StringBuilder("Hello");

        sb2.append(" World"); // allowed

        // sb2 = new StringBuilder("New"); // ERROR
    }
}

class A{
    int id;
    String name;
    // 'package' is a reserved keyword in Java; rout
    float pkg;
    String branch;

    void display1(){
        System.out.println(this.id);
        System.out.println(name);
        System.out.println(pkg);
    }
    void display2(){
        System.out.println(this.id);
        System.out.println(name);
        System.out.println(pkg);
        System.out.println(this.branch);
    }

    // this work as default constructor
    A(){
        this(100000, "NA", 1.0f);
    }
    A(int id, String name, float pkg){
        this.id = id;
        this.name = name;
        this.pkg = pkg;
    }

    A(int id, String name, float pkg, String branch){
        this.id = id;
        this.name = name;
        this.pkg = pkg;
        this.branch = branch;
    }


}
