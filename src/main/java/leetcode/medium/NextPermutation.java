package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/13/2019
 */
public class NextPermutation {

    @Test
    public void test(){
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 1, 4, 2})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{3, 4, 1, 2})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{2, 4, 3, 1})));
        System.out.println(Arrays.toString(nextPermutation(new int[]{5, 1, 1})));
    }

    public int[] nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int b = nums[i];
            if (i == 0) {
                Arrays.sort(nums, i, nums.length);
                break;
            }
            int a = nums[i - 1];
            if (a < b) {
                int theBiggerOneIndex = findTheBiggerOne(nums, i - 1, nums.length - 1, a);
                swap(nums, i - 1, theBiggerOneIndex);
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private int findTheBiggerOne(int[] nums, int start, int end, int target) {
        for (int i = end; i >= start; i--) {
            if (nums[i] > target) {
                return i;
            }
        }
        return start;
    }
}
