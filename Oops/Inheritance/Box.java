package Oops.Inheritance;

public class Box {
    double height;
    // private double height;
    // by private it make length only accessible inside this class
    double width;
    double length;

    Box(){
        this.height = -1;
        this.length = -1;
        this.width = -1;
        
    }

    // cube
    Box(double side){
        this.height = side;
        this.length = side;
        this.width = side;
    }

    // cuboid
    Box(double height, double length, double width){
        this.height = height;
        this.length = length;
        this.width = width;
    }

    // copy constructor
    Box( Box old ){
        this.height = old.height;
        this.length = old.length;
        this.width = old.width;
    }

}
