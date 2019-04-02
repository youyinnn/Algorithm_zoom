package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 4/2/2019
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry) {
                int tmp = digits[i] + 1;
                if (tmp >= 10) {
                    digits[i] = tmp % 10;
                } else {
                    digits[i] = tmp;
                    carry = false;
                }
            }
        }
        if (carry) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else {
            return digits;
        }
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{})));
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
