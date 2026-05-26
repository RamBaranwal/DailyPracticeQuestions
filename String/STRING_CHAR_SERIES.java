import java.util.Arrays;

public class STRING_CHAR_SERIES {
    public static void main(String[] args) {
        // the time complexity is O(n^2)
        // this is pointing every time new string waste of memory so we need any class
        // which os mutable
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            System.out.print(ch + " ");
            series = series + ch;
        }
        System.out.println();
        System.out.println(series);

        // StringBuilder is mutable we change the value inside it

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            sb.append(ch);
            sb.append(" ");
        }
        System.out.println(sb.charAt(4));
        System.out.println(sb.capacity());
        System.out.println(sb.indexOf("abc"));
        System.out.println(sb.lastIndexOf("a"));
        sb.reverse();
        System.out.println(sb.toString());

        String name = "kunal kushwaha";
        System.out.println(Arrays.toString(name.toCharArray()));
        String words = "this is my house where i lived few year back";
        String[] word = words.split(" ");
        System.out.println(Arrays.toString(word));
        String randomStufString = "this 9 Camel case String 78,is my @ new house / i am glad to see you % $ # by the way from where are ?? you";
        String[] random = randomStufString.split("[^a-zA-z0-9]+");
        System.out.println(Arrays.toString(random));
    }
}
