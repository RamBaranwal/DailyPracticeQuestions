package stackAndQueue.stack;

import stackAndQueue.queue.CustomException;

public class CustomStack {
    protected int[] data;
    private final static int DEFAULT_SIZE = 10;
    private int ptr;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size){
        this.data = new int[size];
        this.ptr = -1;
    }

    public boolean push(int item) throws CustomException{
        if(isFull()) {
            throw new CustomException("Stack is overflow!!!");
        }
        data[++ptr] = item;
        return true;
    }

    public boolean isFull(){
        if(data.length - 1 == ptr) return true;
        return false;
    }

    public int pop() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Stack is underflow!!!");
        }
        // both are same
        // int remove = data[ptr];
        // ptr--;
        // return remove;
        return this.data[ptr--];
    }

    public boolean isEmpty(){
        return ptr == -1;
    }

    public int peek() throws CustomException{
        if(isEmpty()){
            throw new CustomException("Stack is underflow!!!");
        }
        return data[ptr];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for (int i = 0; i <= ptr; i++) {
            sb.append(this.data[i]);

            if (i != ptr) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}
