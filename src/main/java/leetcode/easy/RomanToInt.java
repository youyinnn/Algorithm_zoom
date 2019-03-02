package leetcode.easy;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/2/2019
 */
public class RomanToInt {

    private int mapping(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        char[] rs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < rs.length;) {
            int nowInt = mapping(rs[i]), nextInt;
            if (i + 1 < rs.length
                    && (nextInt = mapping(rs[i + 1])) > nowInt) {
                ans += nextInt - nowInt;
                i += 2;
            } else {
                ans += nowInt;
                i++;
            }
        }
        return ans;
    }

    @Test
    public void test2(){
        System.out.println(romanToInt("III"));
    }
}
