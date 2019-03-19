package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/19/2019
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            int candidate = candidates[i];
            LinkedList<Integer> one = new LinkedList<>();
            one.add(candidate);
            get(ans, one, candidates, i, target - candidate);
        }
        return ans;
    }

    private void get(List<List<Integer>> ans, List<Integer> one, int[] candidates, int offset, int target) {
        if (target == 0) {
            ans.add(new LinkedList<>(one));
        }
        if (candidates[offset] <= target) {
            for (int i = offset; i < candidates.length; i++) {
                int candidate = candidates[i];
                if (candidate <= target) {
                    one.add(candidate);
                    get(ans, one, candidates, i, target - candidate);
                    one.remove(one.size() - 1);
                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
