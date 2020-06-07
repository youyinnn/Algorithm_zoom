package leetcode.race.week192;

import java.util.Arrays;

import org.junit.Test;

public class q1 {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            ans[count++] = nums[i];
            ans[count++] = nums[i + nums.length / 2];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] a = {2,3,5,4,1,7};
        System.out.println(Arrays.toString(shuffle(a, 4)));
    }
}