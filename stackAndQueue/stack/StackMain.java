package stackAndQueue.stack;

import stackAndQueue.queue.CustomException;

public class StackMain {
    public static void main(String[] args) throws CustomException {
        CustomStack stack = new CustomStack(6);
        System.out.println(stack.push(4));
        stack.push(2);
        stack.push(5);
        stack.push(9);
        stack.push(10);
        stack.push(12);
        System.out.println(stack);
        stack.pop();
        stack.push(14);
        System.out.println(stack);
        // stack.pop();
        // stack.push(14);
        System.out.println(stack.peek());

        DynamicStack dstack = new DynamicStack(6);
        System.out.println(dstack.push(4));
        dstack.push(2);
        dstack.push(5);
        dstack.push(9);
        dstack.push(10);
        dstack.push(12);
        System.out.println(dstack);
        dstack.pop();
        dstack.push(14);
        System.out.println(dstack);
        dstack.push(24);
        dstack.push(34);
        dstack.push(44);
        System.out.println(dstack);
    }
}
