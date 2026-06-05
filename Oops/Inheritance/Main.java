package Inheritance;

public class Main {
    public static void main(String[] args) {
        // Box obj = new Box();
        // System.out.println(obj.height + " " + obj.length + " " + obj.width);

        // Box obj2 = new Box(4);
        // System.out.println(obj2.height + " " + obj2.length + " " + obj2.width);

        // Box obj3 = new Box(4.5, 8.5, 7.5);
        // System.out.println(obj3.height + " " + obj3.length + " " + obj3.width);

        // Box boxCopy = new Box(obj);
        // System.out.println(boxCopy.height + " " + boxCopy.length + " " + boxCopy.width);
        // boxCopy.length = 4.7;
        // boxCopy.height = 5.9;
        // boxCopy.width = 6.2;
        // System.out.println(boxCopy.height + " " + boxCopy.length + " " + boxCopy.width);

        BoxWeight box4 = new BoxWeight();
        // automatically called super
        System.out.println(box4.weight + " " + box4.height + " " + box4.length + " " + box4.width);
        
        BoxWeight box5 = new BoxWeight(4.5, 5.7, 6.3);
        // we use super to get parent constructor into use not making manually 
        System.out.println(box5.weight + " " + box5.height + " " + box5.length + " " + box5.width);
        
        BoxWeight box6 = new BoxWeight(9.0, 8.0, 7.0, 6.0);
        // we manually assign them the values thi.height = height but if some changes happen into
        // parent it is not getting affect it may be good and bad both 
        System.out.println(box6.weight + " " + box6.height + " " + box6.length + " " + box6.width);
    }
}
