package skill;

/**
 * @author youyinnn
 */
public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("");
        sb.append("Hello").append("my").append("name").append("is").append("youyinnn");
        System.out.println(sb);
        sb.insert(5, " ")
                .insert(8, " ")
                .insert(13," ")
                .insert(16, " ")
                .insert(sb.length() , "!");
        System.out.println(sb);
        System.out.println(sb.delete(sb.length() - 1, sb.length()));
        System.out.println(sb.reverse());
    }

}
