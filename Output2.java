import java.util.Scanner;

public class Output2 {
    private int findMaxGuest(int[] entry, int[] exit){
        int[] currGuest = new int[entry.length];
        currGuest[0] = entry[0] - exit[0];
        int max = 0;
        for(int i = 1; i < entry.length; i++){
            currGuest[i] = currGuest[i - 1] + entry[i] - exit[i];
            max = Math.max(max, currGuest[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] entry = new int[n];
        int[] exit = new int[n];
        for(int i = 0 ; i < n; i++){
            entry[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n; i++){
            exit[i] = sc.nextInt();
        }
        Output2 obj = new Output2();
        int res = obj.findMaxGuest(entry, exit);
        System.out.println(res);
        sc.close();
    }
}
