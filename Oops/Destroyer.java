class A{
    String value;
    A(String value){
        this.value = value;
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Object is destroyed ");
    }
}

public class Destroyer {
    public static void main(String[] args) {
        A obj;
        for(int i = 0; i < 1000000; i++){
            obj = new A("random value: " + i);
            System.out.println(obj);
        }
    }
}