package stackAndQueue.queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue(5);
        queue.push(45);
        System.out.println(queue.push(24));
        queue.push(12);
        queue.push(23);
        // queue.push(22);
        // queue.push(21);
        queue.push(29);
        System.out.println(queue);
        queue.pop();
        queue.push(34);
        System.out.println(queue);
        System.out.println(queue.peek());

        DynamicQueue dQueue = new DynamicQueue(5);
        dQueue.insert(34);
        dQueue.insert(33);
        dQueue.insert(32);
        dQueue.insert(31);
        dQueue.insert(30);
        dQueue.insert(29);
        dQueue.insert(28);
        System.out.println(dQueue);
        dQueue.remove();
        dQueue.insert(45);
        dQueue.insert(46);
        System.out.println(dQueue);

        CicularQueue stack2 = new CicularQueue(5);
        stack2.insertloop(31);
        stack2.insertloop(32);
        stack2.insertloop(33);
        stack2.insertloop(34);
        stack2.insertloop(35);
        stack2.insertloop(36);
        System.out.println(stack2);
    }
}
