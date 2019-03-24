package leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/23/2019
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        backtracking(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tmp.contains(nums[i])) {
                    tmp.add(nums[i]);
                    backtracking(ans, tmp, nums);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(permute(new int[]{1, 2, 3}));
    }

}
