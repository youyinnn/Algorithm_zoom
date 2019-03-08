package leetcode.easy;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/8/2019
 */
public class ImplementIndexOf {

    @Test
    public void test(){
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("", ""));
    }

    public int strStr(String haystack, String needle) {
        // O (n * m)
        if (needle.isEmpty()) {
            return 0;
        }
        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int n = t.length;
        int m = p.length;
        for (int i = 0; i <= n - m; i++){
            int j = 0;
            while(j < m && p[j] == t[i + j]){
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    // another way to solve this is kmp algorithm with O(n + m) time complexity
}
