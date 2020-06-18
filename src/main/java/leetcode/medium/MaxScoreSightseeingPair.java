package leetcode.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxScoreSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int maxI = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            maxI = Math.max(maxI, A[j - 1] + j - 1);
            max = Math.max(max, maxI + A[j] - j);
        }
        return max;
    }

    @Test
    public void t1() {
        int[] a = {8,1,5,2,6};
        assertEquals(11, maxScoreSightseeingPair(a));

        int[] b = {2,2,1};
        assertEquals(3, maxScoreSightseeingPair(b));
    }

}