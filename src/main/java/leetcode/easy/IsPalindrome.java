package leetcode.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IsPalindrome {
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] ca = s.toCharArray();
        int left = 0, right = ca.length - 1;
        while (left < right) {
            while (left < right && !vaild(ca[left])) {
                left++;
            }
            while (left < right && !vaild(ca[right])) {
                right--;
            }
            if (ca[left++] != ca[right--]) {
                return false;
            }
        }
        return true;
    }

    public boolean vaild(char c) {
        return (c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    @Test
    public void test() {
        assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(false, isPalindrome("race a car"));
        assertEquals(true, isPalindrome(""));
        assertEquals(true, isPalindrome(".,"));
    }
}