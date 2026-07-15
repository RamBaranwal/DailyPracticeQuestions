package stackAndQueue;
import java.util.LinkedList;
import java.util.Queue;

public class Quening {
    public static void main(String[] args) {
        Queue<Integer> qe = new LinkedList<>();
        qe.add(4);
        qe.add(3);
        qe.add(1);
        qe.add(6);
        qe.add(8);
        System.out.println(qe);
        // used to remove the first element
        // but different from remove() -> also delete element from first
        // but poll() -> returns null if list is empty and remove() -> throws exceptions
        System.out.println(qe.poll());
        System.out.println(qe);
        System.out.println(qe.peek());
        System.out.println(qe);
        System.out.println(qe.remove());
        System.out.println(qe);
        qe.offer(34);
        qe.offer(43);
        // offer() is just same as add() but the key difference is when there is capacity constraint
        // offer() returns false and add() throws exception
        System.out.println(qe);
        System.out.println(qe.element());
        // both are same element() -> used to see the first value bu not remove it but when {the queue is empty it returns null}
        // both are same peek() -> used to see the first value bu not remove it but when {the queue is empty it returns exceptions}
    }
}
