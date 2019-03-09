package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/7/2019
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1, r = nums.length - 1, need = 0 - nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == need) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while (r > l && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while (r > l && nums[r] == nums[r+1]) {
                        r--;
                    }
                } else if (nums[l] + nums[r] > need) {
                    r--;
                } else{
                    l++;
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
