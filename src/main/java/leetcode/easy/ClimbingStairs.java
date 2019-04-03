package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 4/2/2019
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int a = 1, b = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = a + b;
            b = a;
            a = ans;
        }
        return ans;
    }

    @Test
    public void test(){
        assertEquals(3, climbStairs(3));
    }
}
