package LinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int size;
    public DLL(){
        this.size = 0;
    }

    private class Node {

        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next, Node prev){
            this.next = next;
            this.data = data;
            this.prev = prev;
        }
    }

    public void insertFirst(int val){
        Node n = new Node(val);
        if(head == null){
            tail = n;
            head = n;
            size++;
            return;
        }

        head.prev = n;
        n.next = head;
        head = n;

        size++;
    }

    public void insertLast(int val){
        Node n = new Node(val);
        if(head == null){
            insertFirst(val);
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;

        size++;
    }

    public void insertLastNotTail(int val){
        Node n = new Node(val);
        if(head == null){
            insertFirst(val);
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = n;
        n.prev = temp;
        tail = n;
        size++;
    }

    public int deleteFirst(){
        if(head == null){
            throw new RuntimeException("List is Empty");
        }
        int val = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        else {
            tail = null;    // list became empty
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if (head == null) {
            throw new RuntimeException("List is Empty");
        }
        int val = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }
        else {
            head = null;    // list became empty
        }
        size--;
        return val;
    }

    public void insert(int val, int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1; i < index; i++){
            temp = temp.next;
        }

        Node n = new Node(val);
        n.next = temp.next;
        n.prev = temp;
        temp.next.prev = n;
        temp.next = n;
        size++;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }

        Node temp = head;

        for(int i = 1; i < index; i++){
            temp = temp.next;
        }
        int val = temp.next.data;

        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
        return val;
    }

    public void insertAfter(int after, int val){
        Node temp = find(after);
        if (temp == null) {
            System.out.println("Node not found");
            return;
        }
        Node n = new Node(val);
        n.next = temp.next;
        if(temp.next != null){
            temp.next.prev = n;
        }
        else{
            tail = null;
        }
        n.prev = temp;
        temp.next = n;
        size++;
    }

    public Node find(int val){
        Node temp = head;
        while (temp != null) {
            if(temp.data == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node index(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for(int j = 0; j < i; j++){
            temp = temp.next;
        }
        return temp;
    }

    public void displayFromHead(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayRev(){
        if(head == null){
            System.out.println("END");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(" -> ");
            temp = temp.prev;
        }
        System.out.print("END");
    }

    public void displayFromTail(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("END");
    }

    public void getSize(){
        System.out.println(size);
    }

}
