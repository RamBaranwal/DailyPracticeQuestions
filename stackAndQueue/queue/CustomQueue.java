package stackAndQueue.queue;


public class CustomQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int end;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        this.data = new int[size];
        this.end = 0;
    }

    public boolean push(int item) throws CustomException{
        if(isFull()){
            throw new CustomException ("Queue is overflow!!!");
        }

        data[end++] = item;
        return true;
    }

    public boolean isFull(){
        if(end == data.length){
            return true;
        }
        return false;
    }

    public int pop() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Queue is underflow!!!");
        }
        int remove = this.data[0];
        for(int i = 1; i < end; i++){
            data[i - 1] = data[i];
        }
        end--;
        return remove;
    }

    public boolean isEmpty(){
        if(end == 0){
            return true;
        }
        return false;
    }

    public int peek() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Queue is underflow!!!");
        }
        return data[0];
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < end; i++){
            sb.append(this.data[i]);

            if(i != end - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
