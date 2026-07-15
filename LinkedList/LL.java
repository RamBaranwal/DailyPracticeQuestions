package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    private class Node{

        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public LL(){
        this.size = 0;
    }

    // question leetcode 21
    public static LL merge(LL fList, LL sList){
        Node f = fList.head;
        Node s = sList.head;

        LL ans = new LL();
        while(f != null && s != null){
            if(f.data <= s.data){
                ans.insertLast(f.data);
                f = f.next;
            }
            else{
                ans.insertLast(s.data);
                s = s.next;
            }
        }
        while (f != null) {
            ans.insertLast(f.data);
            f = f.next;
        }
        while (s != null) {
            ans.insertLast(s.data);
            s = s.next;
        }
        return ans;
    }

    // question leetcode 83
    public void duplicate(){
        Node temp = head;
        while (temp != null && temp.next != null) {
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
                size--;
            }
            else{
                temp = temp.next;
            }
        }
        tail = temp;
        tail.next = null;
    }

    public void insertFirst(int val){
        Node n = new Node(val);

        if(head == null){
            head = n;
            tail = n;
            size++;
            return;
        }
        n.data = val;
        n.next = head;
        head = n;

        // if(tail == null){
        //     tail = head;
        // }

        size++;
    }

    
    public void getSize(){
        System.out.println(size);
    }

    public void getHeadTail(){
        System.out.println(head.data);
        System.out.println(tail.data);
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node n = new Node(val);
        tail.next = n;
        tail = n;
        size++;
    }

    public void insertRec(int val, int index){
        head = insertHelper(val, index, head);
    }

    private Node insertHelper(int val, int index, Node n){
        if(index == 0){
            Node temp = new Node(val);
            temp.next = n;
            size++;
            return temp;
        }

        n.next = insertHelper(val, index - 1, n.next);
        return n;
    }

    public void insert(int val, int index){
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
        // ======== both are right ===========
        // Node n = new Node(val);
        // n.next = temp.next;
        // temp.next = n;
        // ===================================
        Node n = new Node(val, temp.next);
        temp.next = n;

        size++;
    }

    // if tail is not present
    public void insertLastNotTail(int val){

        if(head == null){
            insertFirst(val);
            return;
        }

        Node n = new Node(val);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = n;
        tail = n;
        size++;
    }

    public int deleteFirst(){
        if(head == null){
            throw new RuntimeException("List is Empty");
        }
        int val = head.data;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            return deleteFirst();
        }
        int val = tail.data;
        Node secondLast = get(size - 2);
        tail = secondLast;
        tail.next = null;
        size--;
        return val;

    }

    public int delete(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if(index == 0){
            return deleteFirst();
        }
        if(index == size - 1){
            return deleteLast();
        }
        Node prev = get(index - 1);
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;

        return val;
    }

    public Node get(int index){
        Node n = head;
        for(int i = 0; i < index; i++){
            n = n.next;
        }
        return n;
    }

    public Node find(int val){
        Node n = head;
        while(n != null){
            if(n.data == val){
                return n;
            }
            n = n.next;
        }
        return null;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

}