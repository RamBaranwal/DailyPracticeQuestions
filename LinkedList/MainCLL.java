package LinkedList;

public class MainCLL {
    public static void main(String[] args) {
        CLL obj = new CLL();
        obj.insert(2);
        obj.insert(4);
        obj.insert(6);
        obj.insert(8);
        obj.insert(10);
        obj.display();
        obj.delete(4);
        obj.display();
        obj.delete(2);
        obj.display();
        obj.delete(10);
        obj.display();
    }
}
