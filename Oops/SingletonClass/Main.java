package SingletonClass;

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        // every new obj take the same reference
        // if change any thing it will affect the same obj
        obj.num = 10;
        obj2.num = 30;
        obj.num = 50;
        System.out.println(obj2.num);
        System.out.println(obj.num);
    }
}
