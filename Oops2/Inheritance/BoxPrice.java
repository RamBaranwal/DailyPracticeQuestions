package Oops2.Inheritance;

public class BoxPrice extends BoxWeight{
    double price;

    BoxPrice(){
        super();
        this.price = -1;
    }

    BoxPrice(int side, float weight, double price){
        super(side, weight);
        this.price = price;
    }
}
