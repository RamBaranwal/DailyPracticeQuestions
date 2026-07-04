// package SumPepTest1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.util.Arrays;
import java.io.IOException;

public class String2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String2 obj = new String2();
        String res = obj.findFrequency(st);
        System.out.println(res);
    }

    private String findFrequency(String st) {
        int[] fre = new int[26];
        for (char ch : st.toCharArray()) {
            fre[ch - 'a']++;
        }
        String res = "";
        for (int i = 0; i < 26; i++) {
            if (fre[i] == 1) {
                res += (char) (i + 'a');
            } else if (fre[i] != 0) {
                res += (char) (i + 'a') + "" + fre[i];
            }

        }
        return res;
    }
}
