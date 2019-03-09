package leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/9/2019
 */
public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int len = 0;
        int range = 0, set = 0;
        for (int i = 0; i < nums.length; i++) {
            if (range < nums.length - 1 &&
                    nums[range] == nums[range + 1]) {
                range++;
            } else {
                nums[set] = nums[range];
                set++;
                range++;
                len++;
            }
        }
        return len;
    }

    @Test
    public void test(){
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
