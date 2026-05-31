package packages.newA;
import static packages.newB.Message.message;
public class Greeting {
    public static void main(String[] args) {
        System.out.println("Hello Ni How");
        message();
    }
}

// to run this
// go inside the oops folder
// javac packages/newA/Greeting.java packages/newB/Message.java       -> for path
// java packages.newA.Greeting                                        -> for packages
