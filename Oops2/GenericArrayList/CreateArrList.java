package Oops2.GenericArrayList;

import java.util.Arrays;

public class CreateArrList {


    private static int DEFAULT_SIZE = 2;
    int[] arr;
    int size = 0;

    public CreateArrList(){
        this.arr = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        arr[size++] = num;
    }

    public int remove(){
        int removed = arr[--size];
        return removed;
    }

    public int getIndex(int i){
        return arr[i];
    }

    public int size(){
        return size;
    }

    private boolean isFull(){
        if(size == arr.length){
            return true;
        }
        else{
            return false;
        }
    }

    private void resize(){
        int[] temp = new int[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }

    public String toString2() {
        return "Created Array { " + Arrays.toString(arr) + " size = " + size + " }";
    }
    public static void main(String[] args) {
        // without use of <> we can also create arraylist
        // ArrayList obj = new ArrayList();
        // obj.add(1);
        // obj.add(4);
        // obj.add(2, 3);
        // System.out.println(obj.toString());
        // System.out.println(obj.size());

        CreateArrList num = new CreateArrList();
        num.add(2);
        num.add(2);
        num.add(2);
        num.add(2);
        num.add(2);
        System.out.println(num);
        int n = num.remove();
        System.out.println(n);
        System.out.println(num.toString());
        // we can do this only here not outside of this class so it is not a good method
        System.out.println(Arrays.toString(num.arr));
        // as we see that after removing element still present but not into the size so we override upon it
        System.out.println(num.toString2());
        num.add(4);
        System.out.println(num);
        // System.out.println(arr);
        System.out.println(num.size);
        // for only this class we access it directly so we think no need of size() -> a getter method but
        // for another class due to private it is not accessable so to access it make its getter method
        System.out.println(num.size());
        System.out.println(num.getIndex(3));
    }
}
