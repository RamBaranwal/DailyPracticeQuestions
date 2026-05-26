import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class STRING {

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        String a = "RAM";
        String b = "Ram";
        System.out.println(a == b);
        String c = new String("Ram");
        String d = new String("Ram");
        System.out.println(c == d);
        System.out.println(a.charAt(1));
        System.out.println(Integer.toString(78));
        System.out.println(Arrays.toString(new int[] { 3, 4, 1, 5 }));
        String name = null;
        System.out.println(name);
        Integer num = new Integer(45);
        System.out.println(num);
        num += 65;
        System.out.println(num);

        // using the float
        float f = 2131.4131f; // always remember f into the last required
        System.out.printf("formatting of the float %.2f %n", f); // for formatting we used printf

        System.out.printf("this is the new para name is %s and author is %s %n", "Journey", "Ram");

        System.out.printf("the pi value till 3 decimal is %.3f", Math.PI);

        System.out.printf("this is the use of '%%d' only for whole number %d %n", 4);
        System.out.printf("this is the char taking formate %%c %c %n", 'r');

        System.out.printf("this is showing the zeros or any number leading with zeros %05d %n", 45);
        // if i want it leads with 3 rather than 0 then
        String result = String.format("%05d", 45).replace('0', '3');
        System.out.println("this is showing the zeros or any number leading with zeros " + result);
        // System.out.printf( %05d %n", 45);
        System.out.printf("this is taking till i want it store the values %010.4f", 14.45);

        Date date = new Date();
        System.out.printf("Time: %tT\n", date); // show time only

        Date time = new Date();
        // System.out.printf("%tX", time); // tX not included into the java
        System.out.printf("%tH%n", time); // hour current
        System.out.printf("%tM%n", time); // min current
        System.out.printf("%tS%n", time); // sec current
        System.out.printf("%tc%n", time); // full date day and time with ist

        LocalDate ld = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM--dd--yyyy");

        // mm -> minute
        // M -> month // 3
        // MM -> month // 03
        // MMM -> month // Mar
        // MMMM -> month // March
        // DD -> day of year like here 81st day
        // dd -> day of the month
        // YY -> return weak based
        // yy -> year // 26
        // yyyy -> full year // 2026
        // EEEE -> full Sunday or Monday
        // EE -> half Sun or Mon

        String day = ld.format(DateTimeFormatter.ofPattern("EEEE"));
        System.out.println(day);
        String formated = ld.format(formatter);
        System.out.println(formated);

        int week = ld.get(WeekFields.of(Locale.getDefault()).weekOfYear());
        System.out.println(week);


        // String fundamentals
        System.out.println(new Integer(56) + "Kunal");
        System.out.println(new ArrayList<>() + "Kunal");
        // System.out.println(new ArrayList<>() + new Integer(56)); // this is showing error beacuse
        // when we use println it is change any thing into string but when we change two object into string and ""+"" operator involved
        // we keep that one of the values into both be string or a string is present into it

        System.out.println(new ArrayList<>() + "" +new Integer(56));
        
    }
}