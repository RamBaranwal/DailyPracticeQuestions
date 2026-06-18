package StaticExample;

class Test{
    String name;
    Test(String name){
        this.name = name;
    }
}
public class StaticInnerClass {

    static class Test{
        String name;
        Test(String name){
            this.name = name;
        }
    }
    public static void main(String[] args) {

        // both are same method for use purpose

        Test c = new StaticInnerClass.Test("Sunil");
        
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");
        
        System.out.println(a.name);
        System.out.println(b.name);
    }
}

// output
// kunal
// rahul