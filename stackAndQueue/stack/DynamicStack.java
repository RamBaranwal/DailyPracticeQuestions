package stackAndQueue.stack;

import stackAndQueue.queue.CustomException;

public class DynamicStack extends CustomStack{
    public DynamicStack(){
        super();
    }
    public DynamicStack(int n){
        super(n);
    }

    @Override
    public boolean push(int item) throws CustomException{
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++){
                temp[i] = data[i];
            }
            data = temp;
        }
        return super.push(item);
    }
}
