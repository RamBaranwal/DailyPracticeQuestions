package StaticExample;
public class ToStringAnnotation {
    static class Test{
        String name;

        Test(String name){
            this.name = name;
        }

        @Override                    // annotation
        public String toString(){
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");

        // if annotation is not there it prints hexavalues
        System.out.println(a.name);
        System.out.println(a);
        System.out.println(b.name);
        System.out.println(b);
    }
}
