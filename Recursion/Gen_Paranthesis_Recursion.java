import java.util.ArrayList;
import java.util.List;

public class Gen_Paranthesis_Recursion {
    public static List<String> Genrate_Paranthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }
        if (open < n) {
            cur.append('(');
            backtrack(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(res, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid argument, using default n=3");
            }
        }
        List<String> result = Genrate_Paranthesis(n);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
