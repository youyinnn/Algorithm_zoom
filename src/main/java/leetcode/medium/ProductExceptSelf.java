package leetcode.medium;

import java.util.Arrays;

import org.junit.Test;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            ans[i] *= tmp;
        }

        return ans;
    }

    @Test
    public void t1() {
        int[] a = {1, 2, 3, 4, 5};
        System.err.println(Arrays.toString(productExceptSelf(a)));        
        int[] b = {1, 2, 3, 4};
        System.err.println(Arrays.toString(productExceptSelf(b)));
    }
}
