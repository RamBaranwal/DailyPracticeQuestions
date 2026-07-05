package Oops2.GenericArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateGenArrList<T> {
    private static int DEFAULT_SIZE = 2;
    private Object[] arr;
    private int size = 0;

    public CreateGenArrList(){
        this.arr = new Object[DEFAULT_SIZE];
    }

    // ------------- add --------------
    public void add(T num){
        if(isFull()){
            resize();
        }
        arr[size++] = num;
    }

    private boolean isFull(){
        if(size == arr.length){
            return true;
        }
        else{
            return false;
        }
    }

    // ====== resize of arr ========
    private void resize(){
        Object[] temp = new Object[arr.length * 2];
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        arr = temp;
    }

    // ------------- remove -----------------
    public T remove(){
        // T is smaller one when we directly implement it which means smaller to bigger so we typecast it
        T removed = (T)(arr[--size]);
        return removed;
    }

    // ------------- getIndex -------------------
    public T getIndex(int i){
        return (T)(arr[i]);
    }

    // ------------- size -------------------
    public int size(){
        return size;
    }

    // ------------- set --------------------
    public void set(int index, T value){
        arr[index] = value;
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, size));
    }

    public String toString2() {
        return "Created Array { " + Arrays.toString(arr) + " size = " + size + " }";
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        CreateGenArrList<Integer> list2 = new CreateGenArrList<>();
        list2.add(4);
        list2.add(3);
        list2.add(1);
        list2.add(9);
        list2.add(8);
        // list2.add("aiujfb ");
        System.out.println(list2.toString2());
        System.out.println(list2.toString());
    }
}