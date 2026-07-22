package stackAndQueue.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Dequening {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(34);
        dq.add(4);
        dq.add(4);
        System.out.println(dq.add(4));
        dq.add(3);
        dq.addFirst(25);
        dq.addLast(21);
        System.out.println(dq);
        System.out.println(dq.element());
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
        System.out.println(dq.removeFirstOccurrence(4));
        System.out.println(dq);
    }
}
