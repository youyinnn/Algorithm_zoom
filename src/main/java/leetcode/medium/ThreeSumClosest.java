package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/7/2019
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Integer closest = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        closest = sum;
                    }
                    int dis = Math.abs(sum - target);
                    if (closest == null) {
                        closest = sum;
                    } else if (dis < Math.abs(closest - target)) {
                        closest = sum;
                    }
                }
            }
        }
        return closest;
    }

    @Test
    public void test1(){
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return closest;
    }

    private int distance(int target, int input) {
        return Math.abs(input - target);
    }

    @Test
    public void test2(){
        //System.out.println(threeSumClosest2(new int[]{0,2,1,-3}, 1));
        System.out.println(threeSumClosest2(new int[]{-1,2,1,-4}, 1));
    }
}
