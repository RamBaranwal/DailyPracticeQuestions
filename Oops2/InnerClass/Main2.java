package Oops2.InnerClass;

public class Main2 {
    static class Test2{
        String name;
        Test2(String name){
            this.name = name;
        }
        void display(){
            System.out.println("welcome " + this.name);
        }
    }

    static class Test3{
        static String name;
        Test3(String name){
            Test3.name = name;
        }
        static void display(){
            System.out.println("Welcome " + Test3.name);
        }
    }
    public static void main(String[] args) {
        Test2 a = new Test2("Rahul");
        a.display();

        Test3 b = new Test3("Karan");
        Test3.display();
    }
}
