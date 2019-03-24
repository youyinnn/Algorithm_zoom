package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/24/2019
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        backtracking(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int start) {
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(ans, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    @Test
    public void test(){
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

}
