package Oops.Constructor;

public class Main {
    public static void main(String[] args) {
        Complex n1 = new Complex(4, 5);
        Complex n2 = new Complex(5);
        n1.println();
        n2.println();

        System.out.println("adding both complex");
        Complex add = n1.add(n2);
        add.println();
    }
}

class Complex{
    int a;
    int b;

    public Complex(int real, int imaginary){
        a = real;
        b = imaginary;
    }

    Complex(int real){
        a = real;
        b = 1;
    }

    Complex add(Complex obj){
        Complex add = new Complex(a + obj.a, b + obj.b);
        return add;
    }

    void println(){
        System.out.println(a + " i" + b);
    }
}
