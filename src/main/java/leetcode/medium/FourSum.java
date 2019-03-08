package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/7/2019
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1, need = target - nums[i] - nums[j];
                while (l < r) {
                    if (nums[l] + nums[r] == need) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r++;
                        }
                    } else if (nums[l] + nums[r] > need) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
        System.out.println(fourSum(new int[]{-1,0,1,2,-1,-4}, -1));
        System.out.println(fourSum(new int[]{0,0,0,0}, 0));
        System.out.println(fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
    }
}
