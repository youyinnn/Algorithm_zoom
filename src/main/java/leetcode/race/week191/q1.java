package leetcode.race.week191;

import java.util.Arrays;

import org.junit.Test;

public class q1 {

    public int maxProduct(final int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    @Test
    public void t1() {
        final int[] a = {1,5,4,5};
        System.out.println(maxProduct(a));
    }
}