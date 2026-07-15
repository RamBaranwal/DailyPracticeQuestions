package LinkedList;

public class Main {
    public static void main(String[] args) {
        // LL obj = new LL();
        // obj.insertFirst(10);
        // obj.insertFirst(20);
        // obj.insertFirst(30);
        // obj.insertFirst(40);
        // obj.display();
        // obj.getSize();
        // obj.getHeadTail();
        // obj.insertLast(50);
        // obj.display();
        // obj.getSize();
        // obj.insert(25, 3);
        // obj.display();
        // obj.getSize();


        // now insert form last
        LL obj2 = new LL();
        // obj2.insertFirst( 5);
        // obj2.insertFirst( 6);
        // obj2.insertFirst( 7);
        // // obj2.display();
        // obj2.insert(10, 0);
        // obj2.insert(20, 1);
        // // obj2.display();
        // obj2.insertLastNotTail(30);
        // obj2.insertLast(40);
        // obj2.insertLast(50);
        // obj2.insert(35, 3);
        // obj2.display();
        // System.out.println(obj2.deleteFirst());
        // obj2.display();
        // System.out.println(obj2.deleteLast());
        // obj2.display();
        // obj2.getHeadTail();
        // System.out.println(obj2.delete(2));
        // obj2.display();
        // System.out.println(obj2.find(30));
        // System.out.println(obj2.find(3));

        // obj2.insertFirst(10);
        // obj2.insertFirst(20);
        // obj2.insertFirst(30);
        // obj2.insertFirst(40);
        // obj2.insertFirst(50);
        // obj2.display();
        // obj2.insertRec(25, 3);
        // obj2.display();

        LL obj3 = new LL();
        obj3.insertLast(4);
        obj3.insertLast(4);
        obj3.insertLast(4);
        obj3.insertLast(5);
        obj3.insertLast(5);
        obj3.insertLast(6);
        obj3.insertLast(7);
        obj3.insertLast(7);
        // obj3.duplicate();
        obj3.display();

        LL obj4 = new LL();
        obj4.insertLast(5);
        obj4.insertLast(6);
        obj4.insertLast(8);
        obj4.insertLast(9);
        obj4.insertLast(10);
        obj4.insertLast(11);
        obj4.display();

        LL ans = LL.merge(obj3, obj4);
        ans.display();
    }
}
