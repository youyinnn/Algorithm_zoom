package skill;

import java.util.Arrays;

/**
 * @author youyinnn
 */
public class StringTest {

    public static void main(String[] args) {
        String a = "Hello LanQiaoBei";
        System.out.println(a.substring(0, 5));
        System.out.println(a.replace('H', 'E'));
        System.out.println(a.replaceAll("[a-z]", "+"));
        System.out.println(a.replace("e", "*"));
        System.out.println(a.replaceFirst("e", "+"));
        System.out.println(a.contains("Lan"));
        System.out.println(a.indexOf("Lan"));
        System.out.println(a.lastIndexOf('e'));

        String b = "123456";
        int i = Integer.parseInt(b);
        String s = String.valueOf(i);

        String text = "Hello my name is LanQiaoBei!";
        String[] splitText = text.split(" ");
        System.out.println(Arrays.toString(splitText));
        for (String word : splitText) {
            System.out.println(word.toLowerCase());
        }
    }

}
