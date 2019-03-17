package leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/17/2019
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int maxMatch = 0;
        s = "+" + s;
        int[] dp = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 2; i < chars.length; i++) {
            char now = chars[i];
            if (now == ')') {
                char pre = chars[i - 1];
                if (pre == '(') {
                    dp[i] = 2 + dp[i - 2];
                } else if (chars[i - dp[i - 1] - 1] == '('){
                    dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
                }
            }
            maxMatch = Math.max(dp[i], maxMatch);
        }
        return maxMatch;
    }

    @Test
    public void test(){
        assertEquals(6, longestValidParentheses("(())()"));
        assertEquals(2, longestValidParentheses(")()"));
        assertEquals(4,longestValidParentheses(")()())"));
        assertEquals(2,longestValidParentheses("(()"));
        assertEquals(8,longestValidParentheses("()((()))"));
        assertEquals(0,longestValidParentheses(""));
        assertEquals(0,longestValidParentheses(")"));
        assertEquals(0,longestValidParentheses(")))))"));
        assertEquals(22,longestValidParentheses(")(((((()())()()))()(()))("));
        assertEquals(4,longestValidParentheses("()()"));
        assertEquals(6,longestValidParentheses("()(())"));
    }

}
