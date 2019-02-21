package leetcode;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/18/2019
 */
public class LongestPalindromicSubString {

    @Test
    public void testIsPalindrome(){
        String src = "abaaaba";
        System.out.println(isPalindrome(src.toCharArray(), 0, src.length() - 1));
        System.out.println(isPalindrome(src.toCharArray(), 1, 5));
        System.out.println(isPalindrome(src.toCharArray(), 1, 1));
        System.out.println(isPalindrome(src.toCharArray(), 1, 4));
    }

    @Test
    public void testLastIndexFrom(){
        String src = "abaaaba";
        System.out.println(lastIndexFrom(src.toCharArray(), 'a', 0, src.length() - 1));
        System.out.println(lastIndexFrom(src.toCharArray(), 'a', 2, 2));
        System.out.println(lastIndexFrom(src.toCharArray(), 'a', 2, 5));
        System.out.println(lastIndexFrom(src.toCharArray(), 'a', 0, 4));
    }

    public int lastIndexFrom(char[] chars, char target, int begin, int end) {
        // slower in leetcode case
        for (int i = end; i >= begin; i--) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public boolean isPalindrome(char[] src, int begin, int end) {
        while(begin < end) {
            if(src[begin++] != src[end--]) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars.length - i < end - start + 1) {
                break;
            }
            char nowC = chars[i];
            int next = i;
            do {
                next = s.indexOf(nowC, next + 1);
                if (next - i + 1 < end - start + 1) {
                    continue;
                }
                if (next > 0) {
                    if (next - i + 2 > end - start + 1 && isPalindrome(chars, i + 1, next - 1)) {
                        start = i;
                        end = next + 1;
                        System.out.println(s.substring(start, end));
                    }
                }
            } while (next > 0);
        }
        if (end == 0 && chars.length != 0) {
            return chars[0] + "";
        }
        return s.substring(start, end);
    }

    @Test
    public void testLongestPalindrome(){
        //System.out.println(longestPalindrome("asdddadda"));
        //System.out.println(longestPalindrome("a"));
        //System.out.println(longestPalindrome("aabbb"));
        //System.out.println(longestPalindrome("ac"));
        //System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome2("kabcbaabcbaabcjklcjasjdkajsdddaaadwqdqcqqwsdas"));
    }

    // refer from:
    // https://leetcode.com/problems/longest-palindromic-substring/discuss/3003/Java-easy-understanding-solution.-Beats-97

    public String longestPalindrome2(String s) {
        char[] ca = s.toCharArray();
        if (ca.length == 0) {
            return "";
        }
        int start = 0, end = 0;
        int len = 0;
        for(int i = 0; i < ca.length; i++) {
            if(isPalindrome2(ca, i - len - 1, i)) {
                start = i - len - 1; end = i;
                len += 2;
            } else if(isPalindrome2(ca, i - len, i)) {
                start = i - len; end = i;
                len += 1;
            }
        }
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome2(char[] ca, int s, int e) {
        if(s < 0) {
            return false;
        }
        while(s < e) {
            if(ca[s++] != ca[e--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testLongestPalindrome2(){
        //System.out.println(longestPalindrome2("asdddadda"));
        //System.out.println(longestPalindrome2("a"));
        //System.out.println(longestPalindrome2("aabbb"));
        //System.out.println(longestPalindrome2("ac"));
        //System.out.println(longestPalindrome2(""));
        System.out.println(longestPalindrome2("abccbaabb"));
    }

    private int start, end;
    public String longestPalindrome3(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return "";
        }
        int max = 0;
        for(int i = 0; i < chars.length; i++) {
            if(isPalindrome3(chars, i - max - 1, i)) {
                start = i - max - 1; end = i;
                max += 2;
            } else if(isPalindrome3(chars, i - max, i)) {
                start = i - max; end = i;
                max += 1;
            }
        }
        return s.substring(start, end + 1);
    }

    private boolean isPalindrome3(char[] chars, int head, int tail) {
        if(head < 0) {
            return false;
        }
        if (chars[head] == chars[tail] && start == head + 1 && end == tail - 1) {
            return true;
        }
        while(head < tail) {
            if(chars[head++] != chars[tail--]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testLongestPalindrome3(){
        System.out.println(longestPalindrome3("asdddadda"));
        System.out.println(longestPalindrome3("a"));
        System.out.println(longestPalindrome3("aabbb"));
        System.out.println(longestPalindrome3("ac"));
        System.out.println(longestPalindrome3(""));
        System.out.println(longestPalindrome3("abccbaabb"));
    }
}
