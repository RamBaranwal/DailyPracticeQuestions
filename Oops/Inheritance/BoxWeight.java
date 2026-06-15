package Inheritance;

public class BoxWeight extends Box{

    double weight;

    BoxWeight(){
        this.weight = -1;
    }

    // we are doing it manually so it is making some error because
    // of the we use private length into the Box Class
    
    // BoxWeight(double weight, double height, double length, double width){
    //     // --------------------   ERROR   --------------------------------------------------------
    //     // this.height = height;   // that is private so we cannot use it outside of the class BOX
    //     // ---------------------------------------------------------------------------------------
    //     this.length = length;
    //     this.weight = weight;
    //     this.width = width;
    // }

    // this is i am taking help of parent not making manually by own
    BoxWeight(double length, double height, double width, double weight){
        super(height, length, width);
        this.weight = weight;
    }


    // if we need that into main java file 
    // we want constructor of only three parameter 
    // we have to initialized it then we are able to use it 
    BoxWeight(double height, double length, double width){
        // Error is not coming due to it is taken by parent class box not made here 
        super(height, length, width);
    }

    


    // key difference is both the method is same 
    // by super we can do it directly without manually initializing
    // into child we can manually initialized it
    
    // the difference is when we make some changes into parent class
    // by use of super it is automatically update not have to do manually 
}
