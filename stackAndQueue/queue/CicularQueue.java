package stackAndQueue.queue;

public class CicularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end;
    protected int start;
    protected int size;

    public CicularQueue(){
        this(DEFAULT_SIZE);
    }

    public CicularQueue(int size){
        this.data = new int[size];
        this.end = 0;
        this.start = 0;
        this.size = 0;
    }

    public boolean isFull(){
        if(data.length == size){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    public boolean insert(int item) throws Exception{
        if(isFull()){
            throw new Exception("Queue is overflow!!!");
        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public boolean insertloop(int item){
        if(isFull()){
            start = (start + 1) % data.length;
            size--;
        }

        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is underflow!!!");
        }

        int remove = data[start];
        start = (start + 1) % data.length;
        size--;
        return remove;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is underflow!!!");
        }

        return data[start];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = start;
        for (int count = 0; count < size; count++) {
            sb.append(data[i]);
            if (count != size - 1) {
                sb.append(", ");
            }
            i = (i + 1) % data.length;
        }
        sb.append("]");
        return sb.toString();
    }
}
