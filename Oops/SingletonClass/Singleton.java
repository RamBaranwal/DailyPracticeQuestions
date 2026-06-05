package SingletonClass;

public class Singleton {
    // we add static to get by the main class not create obj and
    // private used to protect it not access by other it is only access inside particualr block
    private Singleton(){
        System.out.println("Constructor is running once");
    }
    // like Singleton obj = new Singleton same this is for creating reference
    private static Singleton instance;

    int num;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
