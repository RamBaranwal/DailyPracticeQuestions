package LinkedList;

public class MainDLL {
    public static void main(String[] args) {
        DLL obj = new DLL();
        obj.insertFirst(1);
        obj.insertFirst(2);
        obj.insertFirst(7);
        // head is main display method
        obj.displayFromHead();
        obj.displayFromTail();
        obj.insertLast(8);
        obj.insertLast(9);
        obj.insertLast(10);
        // head is main display method
        // obj.displayFromHead();
        // obj.displayFromTail();
        // obj.insertLastNotTail(12);
        // obj.displayFromHead();
        obj.displayRev();
        System.out.println();
        obj.displayFromHead();
        System.out.println(obj.deleteFirst());
        System.out.println(obj.deleteLast());
        obj.displayFromHead();
        obj.insert(5, 3);
        obj.insert(5, 5);
        obj.displayFromHead();
    }
}
