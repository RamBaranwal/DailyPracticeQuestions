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
        
        Test a = new Test("Kunal");
        Test b = new Test("Rahul");
        
        System.out.println(a.name);
        System.out.println(b.name);
    }
}
