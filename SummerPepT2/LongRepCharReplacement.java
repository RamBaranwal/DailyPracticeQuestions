// package SummerPepT2;

/**
 * LongRepCharReplacement
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class LongRepCharReplacement {

    private int findMaxLen(String str, int m){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Character> charMax = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(Character ch : map.keySet()){
            max = Math.max(max, map.get(ch));
        }

        for(Character ch : map.keySet()){
            if(map.get(ch) == max){
                charMax.add(ch);
            }
        }
        int maxLen = 0;
        for(int i = 0; i < charMax.size(); i++){
            char ch = charMax.get(i);
            
            // for left to right;
            for(int j = 0; j < str.length(); j++){
                int mTemp = m;
                int maxTemp = 0;
                for(int k = j; k < str.length(); k++){
                    if(str.charAt(k) != ch){
                        if(mTemp != 0){
                            mTemp--;
                            maxTemp++;
                        }
                        else{
                            break;
                        }

                    }
                    else{
                        maxTemp++;
                    }
                }
                maxLen = Math.max(maxTemp, maxLen);
            }

            // right to left
            for(int j = str.length() - 1; j >= 0; j--){
                int mTemp = m;
                int maxTemp = 0;
                for(int k = j; k >= 0; k--){
                    if(str.charAt(k) != ch){
                        if(mTemp != 0){
                            mTemp--;
                            maxTemp++;
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        maxTemp++;
                    }
                }
                maxLen = Math.max(maxTemp, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        String kStr = br.readLine();
        int k = Integer.parseInt(kStr);
        LongRepCharReplacement obj = new LongRepCharReplacement();
        int res = obj.findMaxLen(str, k);
        System.out.println(res);
    }
}