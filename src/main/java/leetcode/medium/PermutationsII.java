package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/23/2019
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        int[] flags = new int[nums.length];
        backtracking(ans, new ArrayList<>(), nums, flags);
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int[] flags) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (flags[i] == 0) {
                    if (i > 0 && nums[i] == nums[i - 1] && flags[i - 1] == 0) {
                        continue;
                    }
                    tmp.add(nums[i]);
                    flags[i] = 1;
                    backtracking(ans, tmp, nums, flags);
                    flags[i] = 0;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }

}
