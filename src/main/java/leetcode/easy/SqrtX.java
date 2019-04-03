package leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 4/2/2019
 */
public class SqrtX {

    public int mySqrt(int x) {
        int low = 1, high = x, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low > x / low ? low - 1 : low;
    }

    @Test
    public void test(){
        assertEquals(1, mySqrt(1));
        assertEquals(2, mySqrt(8));
        assertEquals(3, mySqrt(9));
        //assertEquals(2, mySqrt(2147483647));
    }

}
