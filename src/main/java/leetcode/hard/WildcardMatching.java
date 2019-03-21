package leetcode.hard;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/21/2019
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        s = "+" + s;
        p = "+" + p;
        boolean[][] dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if (pc == '*') {
                    boolean all = false;
                    for (int k = 0; k <= i && !all; k++) {
                        all = dp[k][j - 1];
                    }
                    dp[i][j] = all;
                } else if (pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = sc == pc && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }

    public boolean isMatch2(String s, String p) {
        s = "+" + s;
        p = "+" + p;
        boolean[][] dp = new boolean[s.length()][p.length()];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < p.length(); j++) {
                char sc = s.charAt(i);
                char pc = p.charAt(j);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] | dp[i - 1][j];
                } else if (pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = sc == pc && dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length() - 1][p.length() - 1];
    }

    public boolean isMatch3(String s, String p) {
        return dfs(s, p, 0, 0) > 1;
    }

    private int dfs(String s, String p, int si, int pi) {
        if (si == s.length() && pi == p.length()) {
            return 2;
        }
        if (si == s.length() && p.charAt(pi) != '*') {
            return 0;
        }
        if (pi == p.length()) {
            return 1;
        }
        if (p.charAt(pi) == '*') {
            if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') {
                return dfs(s, p, si, pi + 1);
            }
            for (int i = 0; i <= s.length() - si; i++) {
                int ret = dfs(s, p, si + i, pi + 1);
                if (ret == 0 || ret == 2) {
                    return ret;
                }
            }
        }
        if (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?') {
            return dfs(s, p, si + 1, pi + 1);
        }
        return 1;
    }

    @Test
    public void test(){
        System.out.println(isMatch3("adceb", "*a*b"));
        System.out.println(isMatch3("acdcb", "a*c?b"));
    }

}
