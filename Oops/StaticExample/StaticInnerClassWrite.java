public class StaticInnerClassWrite {
    class Test {
        String name;

        Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {

        StaticInnerClassWrite outer = new StaticInnerClassWrite();

        Test a = outer.new Test("Kunal");
        Test b = outer.new Test("Rahul");

        System.out.println(a.name);
        System.out.println(b.name);
    }
}
