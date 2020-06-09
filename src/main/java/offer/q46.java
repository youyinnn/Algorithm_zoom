package offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class q46 {

    public int translateNum(int num) {
        String numStr = num + "";
        return get(numStr, numStr.length());
    }

    public int get(String numStr, int pos) {
        if (pos == 0) return 1;
        else {
            if (pos > 1 && isInAlphabet(numStr, pos - 2, 2)) {
                return get(numStr, pos - 1) + get(numStr, pos - 2);
            } else {
                return get(numStr, pos - 1);
            }
        }
    }

    public boolean isInAlphabet(String numStr, int start, int length) {
        int num = Integer.valueOf(numStr.substring(start, start + length));
        return num > 9 && num < 26;
    }

    @Test
    public void t1() {
        assertEquals(5, translateNum(12258));        
        assertEquals(5, translateNum(1225));
        assertEquals(3, translateNum(122));
        assertEquals(1, translateNum(506));
        assertEquals(3, translateNum(12345));
    }

    public int translateNum2(int num) {
        String numStr = num + "";
        int[] dp = new int[numStr.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int two = (numStr.charAt(i - 2) - '0') * 10 + (numStr.charAt(i - 1) - '0'); 
            if (two > 9 && two < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    @Test
    public void t2() {
        assertEquals(5, translateNum2(12258));        
        assertEquals(5, translateNum2(1225));
        assertEquals(3, translateNum2(122));
        assertEquals(1, translateNum2(506));
        assertEquals(3, translateNum2(12345));
        assertEquals(1, translateNum2(1));
        assertEquals(2, translateNum2(12));
    }



}