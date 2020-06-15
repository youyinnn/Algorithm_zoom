package leetcode.race.week193;

import java.util.Arrays;

import org.junit.Test;

public class q1 {

    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.toString(runningSum(a)));  
    }
}