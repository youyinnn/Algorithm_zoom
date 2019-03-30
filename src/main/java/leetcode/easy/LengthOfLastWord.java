package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/30/2019
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (s.isEmpty() || split.length == 0) {
            return 0;
        } else {
            int i = split.length - 1;
            int len = split[i].length();
            while (len == 0) {
                len = split[--i].length();
            }
            return len;
        }
    }

    @Test
    public void test(){
        assertEquals(3, lengthOfLastWord("123"));
        assertEquals(3, lengthOfLastWord("123 123"));
        assertEquals(3, lengthOfLastWord("123 "));
        assertEquals(3, lengthOfLastWord(" 123"));
        assertEquals(3, lengthOfLastWord(" 123 "));
        assertEquals(0, lengthOfLastWord("  "));
        assertEquals(0, lengthOfLastWord(""));
    }

}
