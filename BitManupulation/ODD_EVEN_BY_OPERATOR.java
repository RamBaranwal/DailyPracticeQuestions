import java.util.Scanner;

public class ODD_EVEN_BY_OPERATOR {
    private String oddOrEven(int n) {
        if ((n & 1) == 1) { // last bit called least significate bit
            return "odd";
        } else {
            return "even";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ODD_EVEN_BY_OPERATOR obj = new ODD_EVEN_BY_OPERATOR();
        System.out.println(obj.oddOrEven(n));
        sc.close();
    }
}

// Explanation
// when we see the bit of any number it is like
// 2^0 * (0/1) + 2^1 * (0/1) + 2^2 * (0/1) + 2^3 * (0/1) + 2^4 * (0/1)
// as we see only the last bit matters onter are multiply by 2 so they are
// already even but last bit
// 2^0 => 1 so when we multiply it by 1 it become odd and if by 0 it become even
// so we check last bit
// n & 1 == 1 so odd other wise even
// n & 1 != 1 so even means its zero