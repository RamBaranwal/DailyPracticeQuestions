package LinkedList;

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL(){
        this.size = 0;
    }

    private class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }

        public Node (int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void insert(int val){
        Node n = new Node(val);
        if(head == null){
            head = n;
            tail = n;
            // tail.next = head;
            size++;
            return;
        }

        tail.next = n;
        n.next = head;
        tail = n;

        size++;
    }

    // 3 conditions are there
    //   --> head
    //   --> tail
    //   --> middle somewhere
    public int delete(int val){
        if(head == null){
            return -1;
        }

        Node curr = head;
        Node prev = tail;

        int index = 0;
        do{
            if(curr.data == val){
                if(head == tail){
                    head = null;
                    tail = null;
                }

                // delete head
                if(curr == head){
                    head = head.next;
                    tail.next = head;
                }

                // delete tail
                else if(curr == tail){
                    tail = prev;
                    prev.next = head;
                }

                else{
                    prev.next = curr.next;
                }

                size--;
                return index;
            }

            prev = curr;
            curr = curr.next;
        }
        while(curr != head);
        return -1;
    }

    public void display(){
        if (head == null) {
            System.out.println("END");
            return;
        }

        Node temp = head;

       do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }
}
