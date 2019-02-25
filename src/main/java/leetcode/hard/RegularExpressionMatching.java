package leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author youyinnn
 * Date 2/24/2019
 */
public class RegularExpressionMatching {

    @Test
    public void testIsMatch11(){
        assertTrue(isMatch("", ""));
        assertTrue(isMatch("aaa", "aaa"));
        assertFalse(isMatch("aaa", ""));
        assertTrue(isMatch("", ".*"));
    }

    @Test
    public void testIsMatch12(){
        assertTrue(isMatch("acb", "a.b"));
        assertTrue(isMatch("acb", ".cb"));
        assertTrue(isMatch("acbb", "..b."));
        assertFalse(isMatch("acb", "ace"));
        assertFalse(isMatch("acbb", "a.b"));
        assertFalse(isMatch("acbb", "a.be"));
        assertFalse(isMatch("acb", "a.be"));
    }

    @Test
    public void testIsMatch13(){
        assertTrue(isMatch("aa", "a*"));
        assertTrue(isMatch("ab", ".*"));
        assertTrue(isMatch("aab", "c*a*b"));
        assertFalse(isMatch("mississippi", "mis*is*p*."));
        assertTrue(isMatch("aaa", "a*a"));
        assertTrue(isMatch("mississippi", "mis*is*ip*."));
    }

    @Test
    public void testIsMatch14(){
        assertFalse(isMatch("ab", ".*c"));
        assertTrue(isMatch("abc", ".*c"));
        assertTrue(isMatch("aaa", "ab*a*c*a"));
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean firstMatch = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            String subPattern = pattern.substring(2);
            return (isMatch(text, subPattern) ||
                    (firstMatch && isMatch(text.substring(1), pattern)));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        s = '+' + s;
        p = '+' + p;
        char[] scs = s.toCharArray();
        char[] pcs = p.toCharArray();
        boolean[][] dp = new boolean[scs.length][pcs.length];
        dp[0][0] = true;
        for (int j = 1; j < pcs.length; j++) {
            if (pcs[j] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i < scs.length; i++) {
            for (int j = 1; j < pcs.length; j++) {
                char pj = pcs[j];
                char si = scs[i];
                if (pj == si || pj == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pj == '*') {
                    if (si != pcs[j - 1] && pcs[j - 1] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                    }
                }
            }
        }
        printDp(scs, pcs, dp);
        return dp[scs.length - 1][pcs.length - 1];
    }

    private void printDp(char[] t, char[] p, boolean[][] dp) {
        StringBuffer head = new StringBuffer("\t");
        for (char c : p) {
            head.append(c).append("\t\t");
        }
        System.out.println(head);
        for (int i = 0; i < dp.length; i++) {
            StringBuffer row = new StringBuffer();
            row.append(t[i]).append('\t');
            for (boolean b : dp[i]) {
                row.append(b).append('\t');
            }
            System.out.println(row);
        }
    }

    @Test
    public void testIsMatch2(){
        assertFalse(isMatch2("mississippi", "mis*is*p*."));
        System.out.println();
        assertTrue(isMatch2("abcd", ".*bcd"));
    }
}
