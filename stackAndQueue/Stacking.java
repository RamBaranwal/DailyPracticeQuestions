package stackAndQueue;

import java.util.Stack;

public class Stacking {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(43);
        st.push(43);
        st.push(43);
        st.push(43);
        st.push(43);

        st.pop();
        st.pop();
        st.pop();
        st.pop();
        st.pop();
        System.out.println(st);
        st.addElement(45);
        st.addFirst(32);
        st.addLast(21);
        System.out.println(st);
        System.out.println(st.empty());
        System.out.println(st.elements());
        System.out.println(st.indexOf(2));
        st.add(12);
        st.add(13);
        System.out.println(st);
        System.out.println(st.indexOf(21));
        System.out.println(st.get(4));
        System.out.println(st.peek());
        System.out.println();
    }
}
