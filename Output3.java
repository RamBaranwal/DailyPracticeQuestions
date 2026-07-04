import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// import java.util.Entry;
public class Output3 {
    private char findOddcolor(char[] color){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < color.length; i++){
            if(map.containsKey(color[i])){
                map.put(color[i], map.get(color[i]) + 1);
            }
            else{
                map.put(color[i], 1);
            }
        }
        // for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        //     if(entry.getValue() % 2 != 0){
        //         return entry.getKey();
        //     }
        // }
        for(Character ch : map.keySet()){
            if(map.get(ch) % 2 != 0){
                return ch;
            }
        }
        return '1';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] color = new char[n];
        for(int i = 0; i < n; i++){
            color[i] = sc.next().charAt(0);
        }
        Output3 obj = new Output3();
        char res = obj.findOddcolor(color);
        System.out.println(res);
        sc.close();
    }
}
