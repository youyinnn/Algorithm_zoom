package leetcode;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/5/2019
 */
public class LongestSubString {

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            System.out.println(s.charAt(j) + "-> i:" + i + ", j:" + j + ", j - i + 1:" + (j - i + 1));
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    @Test
    public void test2(){
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
