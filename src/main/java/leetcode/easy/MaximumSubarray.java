package leetcode.easy;

/**
 * @author youyinnn
 * Date 3/27/2019
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int rMax = 0, max = Integer.MIN_VALUE;
        for (int current: nums) {
            rMax = Math.max(current, current + rMax);
            max = Math.max(max, rMax);
        }
        return max;
    }

}
