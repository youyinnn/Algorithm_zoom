package leetcode.hard;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/21/2019
 */
public class FirstMissingPostive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int flag = 1;
        int i = 0;
        for (; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int num = nums[i];
            if (num > 0) {
                if (num != flag) {
                    break;
                } else {
                    flag++;
                }
            }
        }
        return flag;
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= nums.length && abs > 0 && nums[abs - 1] > 0) {
                nums[abs - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums.length + 1;
    }

    @Test
    public void test(){
        System.out.println(firstMissingPositive2(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive2(new int[]{1, 1}));
    }

}
