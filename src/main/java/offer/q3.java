package offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class q3 {
    public int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]] == 0) {
                hash[nums[i]] = 1;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    @Test
    public void t1() {
        int[] a = {0};
        assertEquals(-1, findRepeatNumber(a));
        int[] b = {2, 3, 1, 0, 2, 5, 3};
        assertEquals(2, findRepeatNumber(b));
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }

                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    @Test
    public void t2() {
        int[] a = {0};
        assertEquals(-1, findRepeatNumber2(a));
        int[] b = {2, 3, 1, 0, 2, 5, 3};
        assertEquals(2, findRepeatNumber2(b));
    }
}