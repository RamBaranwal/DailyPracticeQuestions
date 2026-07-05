package Oops2.ExecptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try{
            System.out.println(divide(a, b));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("please don't use 0 as denominator");
        }
        return a / b;
    }
}
