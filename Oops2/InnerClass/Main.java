package Oops2.InnerClass;

public class Main {
    class Test{
        String name;
        Test(String name){
            this.name = name;
        }
        void display(){
            System.out.println("Wellcome " + this.name);
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Main.Test t1 = obj.new Test("Super 1");
        Main.Test t2 = obj.new Test("Super 2");

        t1.display();
        t2.display();
    }
}
