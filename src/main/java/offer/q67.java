package offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class q67 {

    public boolean isSpace(char c) {
        return c == ' ';
    }

    public boolean isNum(char c) {
        return c - 48 >= 0 && c - 48 <= 9;
    }

    public int toNum(char c) {
        return c - 48;
    }

    public int strToInt(String str) {
        int ans = 0;
        char[] cArr = str.toCharArray();
        boolean minus = false;
        int begin = -1, end = -1;
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            if (!isSpace(c)) {
                if (isNum(c)) {
                    if (begin == -1) {
                        begin = i;
                    }
                } else {
                    if (c == '-' || c == '+') {
                        minus = c == '-';
                    } else {
                        if (begin > -1) {
                            end = i - 1;
                            break;
                        } else {
                            return ans;
                        }
                    }
                }
            } else if (begin > -1) {
                end = i - 1;
                break;
            }
        }
        if (begin == -1 && end == -1 ) {
            return ans;
        }
        end = end == -1 ? str.length() - 1 : end;
        int base = 1;
        for (int i = end; i >= begin; i--) {
            if (base == 1000000000 * 10 && toNum(cArr[i]) > 0) {
                return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            int addOn = (base * toNum(cArr[i])); 
            if (!minus) {
                ans += addOn;
                if (ans < 0) {
                    return Integer.MAX_VALUE;
                }
            } else {
                ans -= addOn;
                if (ans > 0) {
                    return Integer.MIN_VALUE;
                }
            }
            base *= 10;
        }
        return ans;
    }

    @Test
    public void test1() {
        assertEquals(42, strToInt("42"));
        assertEquals(-42, strToInt("   -42"));
        assertEquals(4193, strToInt("4193 with words"));
        assertEquals(0, strToInt("words and 987"));
        assertEquals(Integer.MIN_VALUE, strToInt("-91283472332"));
        assertEquals(Integer.MAX_VALUE, strToInt("91283472332"));
        assertEquals(Integer.MAX_VALUE, strToInt("2147483648"));
        assertEquals(3, strToInt("3.14"));
        assertEquals(0, strToInt("+"));
        assertEquals(0, strToInt("+abc"));
        assertEquals(12345678, strToInt("  0000000000012345678"));
        assertEquals(-2, strToInt("+-2"));
    }

    @Test
    public void test2() {
        // addition overflow
        int a = 147483648;
        int b = 1000000000 * 2;
        int c = a + b;
        System.out.println(c);

        // multiplication overflow
        int d = 1000000000;
        int e = 10;
        System.out.println(d * e);
    }

    
    public int strToInt2(String str) {
        if (str.length() == 0) return 0;
        int ans = 0;
        char[] cArr = str.toCharArray();
        int startIndex = 0;
        // skip spaces
        while (cArr[startIndex] == ' ') {
            startIndex++;
            // all spaces
            if (startIndex == cArr.length) return 0;
        }
        int sign = 1;
        if (cArr[startIndex] == '-') {
            sign = -1;
            startIndex++;
        } else if (cArr[startIndex] == '+') {
            sign = 1;
            startIndex++;
        }
        while (startIndex < cArr.length) {
            if (cArr[startIndex] >= '0' && cArr[startIndex] <= '9') {
                if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
                    // multiplication overflow
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = (ans * 10) + (sign * (cArr[startIndex] - '0'));
                // addiction overflow
                if (sign == -1 && ans > 0) {
                    return Integer.MIN_VALUE;
                }
                if (sign == 1 && ans < 0) {
                    return Integer.MAX_VALUE;
                }
            } else {
                // not a number
                return ans;
            }
            startIndex++;
        }
        return ans;
    }

    @Test
    public void test3() {
        assertEquals(42, strToInt2("42"));
        assertEquals(-42, strToInt2("   -42"));
        assertEquals(4193, strToInt2("4193 with words"));
        assertEquals(0, strToInt2("words and 987"));
        assertEquals(Integer.MIN_VALUE, strToInt2("-91283472332"));
        assertEquals(Integer.MAX_VALUE, strToInt2("91283472332"));
        assertEquals(Integer.MAX_VALUE, strToInt2("2147483648"));
        assertEquals(3, strToInt2("3.14"));
        assertEquals(0, strToInt2("+"));
        assertEquals(0, strToInt2("+abc"));
        assertEquals(12345678, strToInt2("  0000000000012345678"));
        assertEquals(0, strToInt2("+-2"));

        assertEquals(2, strToInt2("+2-2"));
        assertEquals(2, strToInt2("+2----"));
        assertEquals(0, strToInt2("...2----"));
    }

    @Test
    public void test4() {
        assertEquals(Integer.MIN_VALUE, strToInt2("-6147483648"));
        assertEquals(Integer.MAX_VALUE, strToInt2("6147483648"));
        assertEquals(24, strToInt2("24"));
        assertEquals(Integer.MAX_VALUE, strToInt2("20000000000000000000"));
        assertEquals(0, strToInt2("0000000000"));
        assertEquals(12345678, strToInt2("0000000000012345678"));
    }

    @Test
    public void tes5() {
        assertEquals(1, strToInt2("+00000000001"));
        assertEquals(-1, strToInt2("-00000000001"));
    }

    @Test
    public void tes6() {
        assertEquals(-42, strToInt2("   -42"));
        assertEquals(0, strToInt2(""));
        assertEquals(0, strToInt2(" "));
        assertEquals(2147483646, strToInt2("2147483646"));
        assertEquals(2147483647, strToInt2("2147483649"));
        assertEquals(2000000000, strToInt2("2000000000"));
        assertEquals(Integer.MAX_VALUE, strToInt2("20000000000"));
    }

    @Test
    public void tes7() {
        assertEquals(Integer.MAX_VALUE, strToInt2("21474836470"));
        assertEquals(Integer.MAX_VALUE, strToInt2("21474836490"));
        assertEquals(2147483647, strToInt2("2147483647"));
        assertEquals(2147483647, strToInt2("2147483657"));
    }

}