package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dequening {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(34);
        dq.add(4);
        dq.add(3);
        dq.addFirst(25);
        dq.addLast(21);
        System.out.println(dq);
        System.out.println(dq.element());
    }
}
