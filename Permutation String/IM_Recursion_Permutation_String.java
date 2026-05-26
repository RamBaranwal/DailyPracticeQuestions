import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class IM_Recursion_Permutation_String {
	public static ArrayList<String> generatePermutations(String str) {
		// Write your code here
		ArrayList<String> res = new ArrayList<>();
		helper(res, "", str);
		Collections.sort(res);
		return res;
	}
	private static void helper(ArrayList<String> res, String p, String up){
		if (up.isEmpty()) {
            res.add(p);
            return;
        }

		// pick each char one by one
		for(int i = 0; i < up.length(); i++){

			char ch = up.charAt(i);
			
			// remaining char other than the selected one and after added one
			String first = up.substring(0, i);
			String second = up.substring(i + 1, up.length());
			helper(res, p + ch, first + second);
		}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> res = generatePermutations(str);
        System.out.println(res);
        sc.close();

    }
}
