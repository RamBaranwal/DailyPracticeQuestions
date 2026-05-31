package StaticExample;

// no need of import if same folder we are
public class Main {
    public static void main(String[] args) {
        Human kunal = new Human(23, "Kunal Kushwaha", 100000, false);
        Human rahul = new Human(34, "Rahul Shrivashtav", 20000, true);

        System.out.println(kunal.population);
        System.out.println(rahul.population);
    }
}
