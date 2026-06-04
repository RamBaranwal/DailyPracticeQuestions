package SingletonClass;

public class Main {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        obj.num = 10;
    }
}
