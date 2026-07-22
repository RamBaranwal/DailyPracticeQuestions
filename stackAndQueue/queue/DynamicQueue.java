package stackAndQueue.queue;

public class DynamicQueue extends CicularQueue {
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) throws Exception{
        if (isFull()) {

            int[] temp = new int[data.length * 2];

            for (int i = 0; i < size; i++) {
                temp[i] = data[(start + i) % data.length];
            }

            data = temp;
            start = 0;
            end = size;
        }

        return super.insert(item);
    }
}
