package leetcode;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/22/2019
 */
public class StringToInteger {

    @Test
    public void tesAtoi(){
        System.out.println(myAtoi("10000"));
    }

    public int myAtoi(String str) {
        int ans = 0;
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int start = -1, end = 0;
        for(int i = 0; i < chars.length; i++) {
            char now = chars[i];
            if (start == -1) {
                if (!Character.isWhitespace(now)) {
                    if (isNumber(now) || isSign(now)) {
                        start = i;
                    } else {
                        return ans;
                    }
                }
            } else if (isNumber(now)) {
                end = i;
            } else {
                end = i - 1;
                break;
            }
        }
        if (start == -1 || start > end) {
            return 0;
        }
        int base = 1;
        boolean negative = false;
        if (isSign(chars[start])) {
            if (chars[start] == '-') {
                negative = true;
            }
            start++;
        }
        for (int i = end; i >= start; i--) {
            ans += (char2Number(chars[i]) * base);
            base *= 10;
        }
        if ((ans % 10 != char2Number(chars[end]) && !isSign(chars[end])) ||
                (base == 0 && chars[start] != '0')) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return negative ? 0 - ans : ans;
    }

    public boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }
    public boolean isSign(char c) {
        return (c == '-' || c == '+');
    }
    public int char2Number(char c) {
        return c - '0';
    }

    @Test
    public void testChar2Number(){
        System.out.println(char2Number('3'));
    }
}
