package leetcode.easy;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/18/2019
 */
public class ReverseInteger {

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int bit = x % 10;
            x /= 10;
            int tmp = ans * 10 + bit;
            if ((tmp - bit) / 10 != ans) { return 0; }
            ans = tmp;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(reverse(156799));
    }
}
