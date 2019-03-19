package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/19/2019
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int candidate = candidates[i];
            LinkedList<Integer> one = new LinkedList<>();
            one.add(candidate);
            get(ans, one, candidates, i + 1, target - candidate);
        }
        return ans;
    }

    private void get(List<List<Integer>> ans, List<Integer> one, int[] candidates, int offset, int target) {
        if (target == 0) {
            ans.add(new LinkedList<>(one));
        }
        if (offset < candidates.length && candidates[offset] <= target) {
            for (int i = offset; i < candidates.length; i++) {
                if (i != offset && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                int candidate = candidates[i];
                if (candidate <= target) {
                    one.add(candidate);
                    get(ans, one, candidates, i + 1, target - candidate);
                    one.remove(one.size() - 1);
                } else {
                    break;
                }
            }
        }
    }

    @Test
    public void test(){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(combinationSum2(new int[]{4,4,2,1,4,2,2,1,3}, 6));
    }
}
