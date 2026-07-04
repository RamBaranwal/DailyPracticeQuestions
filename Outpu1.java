import java.util.Arrays;
import java.util.Scanner;

public class Outpu1 {
    private int[] findVehicleWheel(int v, int w){
        w = w / 2;
        int car = w - v;
        int bike = v - car;
        return new int[] {bike, car};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(); // vehicle
        int w = sc.nextInt(); // wheels
        
        Outpu1 obj = new Outpu1();
        int[] res = obj.findVehicleWheel(v, w);
        System.out.println(Arrays.toString(res));
        sc.close();
    }
}
