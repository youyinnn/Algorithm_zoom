package offer;

import org.junit.Test;

public class q5 {

    public String replaceSpace(String s) {
        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') spaceCount++;
        }
        int oldI = 0;
        int newI = 0;
        char[] ans = new char[s.length() + (spaceCount * 3) - spaceCount];
        while (newI < ans.length) {
            char now = s.charAt(oldI++); 
            if (now == ' ') {
                ans[newI++] = '%';
                ans[newI++] = '2';
                ans[newI++] = '0';
            } else {
                ans[newI++] = now;
            }
        }
        return new String(ans);
    }

    @Test
    public void t1() {
        System.out.println(replaceSpace("We are the world"));
        System.out.println(replaceSpace("   "));
        System.out.println(replaceSpace("  1 "));
        System.out.println(replaceSpace("  1"));
        System.out.println(replaceSpace("1"));
        System.out.println(replaceSpace(""));
        System.out.println(replaceSpace("1   1"));
    }
}