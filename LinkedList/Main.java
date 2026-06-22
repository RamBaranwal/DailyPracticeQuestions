package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        LL.Node n1 = list.new Node(4);

        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(6);
        list.insertFirst(7);
        list.insertFirst(9);

        list.display();
    }
}
