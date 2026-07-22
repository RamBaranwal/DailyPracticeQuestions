package stackAndQueue.queue;

public class CircularMain {
    public static void main(String[] args) throws Exception{
        CicularQueue cirQue = new CicularQueue(5);
        cirQue.insert(34);
        cirQue.insert(23);
        cirQue.insert(56);
        cirQue.insert(12);
        cirQue.insert(90);
        System.out.println(cirQue);
        cirQue.remove();
        System.out.println(cirQue);
        cirQue.insert(11);
        System.out.println(cirQue);
        cirQue.remove();
        cirQue.remove();
        cirQue.insert(110);
        cirQue.insert(112);
        System.out.println(cirQue);
    }
}
