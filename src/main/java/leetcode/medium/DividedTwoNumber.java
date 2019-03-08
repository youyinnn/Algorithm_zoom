package leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/8/2019
 */
public class DividedTwoNumber {

    @Test
    public void test(){
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        assertEquals(2, divide(7, 3));
        assertEquals(-2, divide(7, -3));
        assertEquals(-2, divide(-7, 3));
        assertEquals(2, divide(-7, -3));
        assertEquals(1, divide(-1, -1));
        assertEquals(-1, divide(1, -1));
        assertEquals(-1, divide(-1, 1));
        assertEquals(1, divide(1, 1));
        assertEquals(Integer.MAX_VALUE, divide(Integer.MIN_VALUE, -1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend > 0) {
            if (divisor > 0) {
                // positive divided by positive
                return pdbp(dividend, divisor);
            } else {
                // positive divided by negative
                return pdbn(dividend, divisor);
            }
        } else {
            if (divisor > 0) {
                // negative divided by positive
                return ndbp(dividend, divisor);
            } else {
                // negative divided by negative
                return ndbn(dividend, divisor);
            }
        }
    }

    private int pdbp(int a, int b) {
        int count = 0;
        while (a >= b) {
            a -= b;
            count++;
        }
        return count;
    }

    private int ndbp(int a, int b) {
        int count = 0;
        while (a + b <= 0) {
            a += b;
            count++;
        }
        return 0 - count;
    }

    private int pdbn(int a, int b) {
        int count = 0;
        while (a + b >= 0) {
            a += b;
            count++;
        }
        return 0 - count;
    }

    private int ndbn(int a, int b) {
        int count = 0;
        while (a <= b) {
            a -= b;
            count++;
        }
        return count == Integer.MIN_VALUE ? Integer.MAX_VALUE : count;
    }

}
