class Mobile{
        int model;
        String name;
        float price;
}
public class UsesOfClass {
    public static void main(String[] args) {
    String str = new String();
    str = "Ram";
    String name = "baranwal";
    System.out.println(name);
    System.out.println(name.toString());
    System.out.println(str);
    System.out.println(str.toString());
    // the differnece here we are using m1.model but String we only write str
        Mobile m1 = new Mobile();
        m1.model = 2025;
        m1.name = "Apple";
        m1.price = 2500.5f;

        System.out.println(m1.model);

    }
}
