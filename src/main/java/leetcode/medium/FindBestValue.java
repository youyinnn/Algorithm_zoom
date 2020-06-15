package leetcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class FindBestValue {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int ifAns = (int) Math.rint(((double)(target - sum) / (double)(arr.length - i)));
            if (ifAns >= arr[i]) {
                sum += arr[i];
            } else {
                ans = Math.min(ans, ifAns);
            }
        }
        return ans == Integer.MAX_VALUE ? arr[arr.length - 1] : ans;
    }

    
    @Test
    public void test() {    
        int[] a = {4, 3, 9};
        assertEquals(3, findBestValue(a, 10));

        int[] b = {2, 3, 5};
        assertEquals(5, findBestValue(b, 10));

        int[] c = {60864,25176,27249,21296,20204};
        assertEquals(11361, findBestValue(c, 56803));
    }
}