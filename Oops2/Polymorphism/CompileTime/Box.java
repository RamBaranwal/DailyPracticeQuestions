package Oops2.Polymorphism.CompileTime;

public class Box {
    int l;
    int w;
    int h;
    Box(){
        this.l = -1;
        this.w = -1;
        this.h = -1;
    }

    Box(int side){
        this.l = side;
        this.w = side;
        this.h = side;
    }

    Box(int l, int w, int h){
        this.l = l;
        this.w = w;
        this.h = h;
    }

    // this is compile time when the obj chekc the construct is present or not before running
}
