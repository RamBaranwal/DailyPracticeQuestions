import java.io.*;

public class LongReplaceCharacter {
    private int findLongestString(String str, int k){
        int[] fre = new int[26];
        int maxFre = 0;
        int left = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            maxFre = Math.max(maxFre, fre[ch - 'A'] + 1);

            while()
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String strK = br.readLine();
        int k = Integer.parseInt(strK);

        LongReplaceCharacter obj = new LongReplaceCharacter();
        int res = obj.findLongestString(str, k);
        System.out.println(res);
    }
}
