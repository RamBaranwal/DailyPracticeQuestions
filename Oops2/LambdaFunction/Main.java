package Oops2.LambdaFunction;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Main{
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        for(int i = 0; i < 4; i++){
            arr1[i] = i * 2;
        }
        // forEach is not applied on array only applicable on arraylist

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(i + 1);
        }

        list.forEach((item) -> System.out.print(2 * item + " "));
        System.out.println();
        System.out.println();

        Consumer<Integer> fun = (item) -> System.out.print(item * 4 + " ");

        fun.accept(2);
        fun.accept(5);
        fun.accept(10);

        Operator sum = (a, b) -> a + b;
        Operator prod = (a, b) -> a * b;
        Operator sub = (a, b) -> a - b;

        Operator sum1 = new Operator() {
            @Override
            public int operation(int a, int b){
                return a + b;
            }
        };

        Main myClaculator = new Main();
        System.out.println(myClaculator.ope(4, 5, sum));
        System.out.println(myClaculator.ope(1, 5, prod));
        System.out.println(myClaculator.ope(3, 5, sub));
        System.out.println(myClaculator.ope(3, 5, sum1));
    }

    private int ope(int a, int b, Operator op){
        return op.operation(a, b);
    }
}


interface Operator{
    int operation(int a, int b);
}

// interface Sum{
//     int sum(int a, int b);
// }