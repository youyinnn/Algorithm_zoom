package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/24/2019
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        backtracking(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int start) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            backtracking(ans, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }

}
