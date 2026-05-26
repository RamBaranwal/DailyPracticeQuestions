public class PATTERN {
    public static void main(String[] args) {
        // output
        // *
        // * *
        // * * *
        // * * * *
        int row = 5;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        // * * * * *
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // * * * *
        // * * *
        // * *
        // *
        for (int i = row; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1
        for (int i = 0; i < row; i++) {
            for (int j = 1; j <= row - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        // * * * *
        // * * *
        // * *
        // *
        for (int i = 0; i < 2 * row; i++) {
            int colInRow = i > row ? 2 * row - i : i;
            for (int j = 0; j < colInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // *
        // * *
        // * * *
        // * * * *
        // * * * * *
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // * * * *
        // * * *
        // * *
        // *
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < row - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("other pattern");
        // output
        // *
        // * * *
        // * * * * *
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}