import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class UniqueSubsequence {
    private int findLargestSuubSequence(String st){
        int left = 0;
        int maxLeng = 0;
        HashSet<Character> set = new HashSet<>();
        for(int right = 0; right < st.length(); right++){
            while(set.contains(st.charAt(right))){
                set.remove(st.charAt(left));
                left++;
            }
            set.add(st.charAt(right));
            maxLeng = Math.max(maxLeng, right - left + 1);
        }
        return maxLeng;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        UniqueSubsequence obj = new UniqueSubsequence();
        int st = obj.findLargestSuubSequence(str);
        System.out.println(st);
    }
}
