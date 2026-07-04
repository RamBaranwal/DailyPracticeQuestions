package Oops2.Abstract;

public class Main{
    public static void main(String[] args) {
        Son obj = new Son(20);
        boolean isMarride = obj.marriage = true;
        System.out.println(isMarride);
        System.out.println(obj.haveMarriage(false));
        String name = obj.name = "Roshan";
        // we can do this;

        // int age = obj.age = 50;
        System.out.println(obj.age);
        // System.out.println(age);

        obj.career();
        obj.haveMarriage(true);
        // System.out.println();

        Parent obj2 = new Parent() {
            @Override
            boolean haveMarriage(boolean done) {
                return done;
            }
        };
        obj2.career();

        Parent obj3 = new Son(33){
            @Override
            void greeting() {
                super.greeting();
            }
        };

        obj3.career();

        Parent obj4 = new Son(89);
        obj4.career();

        Son obj5 = new Son(5){
            @Override
            void greeting() {
                super.greeting();
            }
        };
    }
}