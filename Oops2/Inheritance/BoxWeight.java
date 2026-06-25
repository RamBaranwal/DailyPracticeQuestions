package Oops2.Inheritance;

public class BoxWeight extends Box {
    float weight;

    BoxWeight(){
        super();
        this.weight = -1;
    }

    BoxWeight(BoxWeight other){
        super(other);
        this.weight = other.weight;
    }
    BoxWeight(int l, int w, int h, float weight){
        // here l is not accessable but inside the super accessable how ??
        // ans. -> super directly link to the parent class where l is private so
        // it don't we part of this class we use it only if we want to change into
        // l -> length we have to write this.l = l but unfortunalty it is
        // private so cannot be accessed
        //    ||
        //    \/
        // this.l = l;

        // also super is defined first to know what parent class have then child class define himself
        super(l, w, h);
        this.weight = weight;
        // by this noting change but if we done something changes into the main class Box w -> width
        // it will not reflect here so we use super
        this.w = w;
    }

    BoxWeight(Box other){
        super(other);
    }

    BoxWeight(int side, float weight){
        super(side);
        this.weight = weight;
    }
}
