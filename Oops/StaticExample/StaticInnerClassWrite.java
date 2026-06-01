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

        System.out.println(a.name);
    }
}
