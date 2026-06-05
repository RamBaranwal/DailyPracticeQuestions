package Inheritance;

public class BoxWeight extends Box{

    double weight;

    BoxWeight(){
        this.weight = -1;
    }
    
    BoxWeight(double weight, double height, double length, double width){
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.width = width;
    }

    // if we need that into main java file 
    // we want constructor of only three parameter 
    // we have to initialized it then we are able to use it 
    BoxWeight(double height, double length, double width){
        super(height, length, width);
    }

    // key difference is both the method is same 
    // by super we can do it directly without manually initializing
    // into child we can manually initialized it
    
    // the difference is when we make some changes into parent class
    // by use of super it is automatically update not have to do manually 
}
