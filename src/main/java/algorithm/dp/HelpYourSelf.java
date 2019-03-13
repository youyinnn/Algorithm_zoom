package algorithm.dp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/11/2019
 */
public class HelpYourSelf {

    @Test
    public void testGetMinimal(){
        int[] nums = new int[]{1, 2, 3, -2, 3, -10, 3};
        int[] minimalRange = getMinimalRange(nums);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }
    }

    private int[] getMinimalRange(int[] nums) {
        int[] index = new int[2];
        int min = nums[0];
        int rMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newOne = nums[i];
            int longOne = nums[i] + rMin;
            int tmp = index[0];
            if (newOne < longOne) {
                index[0] = i;
                rMin = newOne;
            } else {
                rMin = longOne;
            }
            if (rMin < min) {
                min = rMin;
                index[1] = i;
            } else {
                index[0] = tmp;
            }
        }
        return index;
    }

    private int[] getMinimalRange(int[] nums, int start, int end) {
        int[] index = new int[2];
        index[0] = start;
        index[1] = start;
        int min = 0;
        int rMin = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < 0) {
                int tmp = i;
                while (i <= end && nums[i] < 0) {
                    rMin += nums[i];
                    i++;
                }
                if (rMin < min) {
                    min = rMin;
                    index[0] = tmp;
                    index[1] = --i;
                }
                rMin = 0;
            }
        }
        return index;
    }

    @Test
    public void testGetMinimalWithRange(){
        int[] nums = new int[]{1, 2, -3, -4, 3, -10, 3};
        int[] minimalRange = getMinimalRange(nums, 0, 3);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }

        minimalRange = getMinimalRange(nums, 3, 6);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }

        minimalRange = getMinimalRange(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }
    }

    private int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int[] getMaximal(int[] nums, int start, int end) {
        int[] index = new int[2];
        index[0] = start;
        index[1] = end;
        int rMax = 0;
        int max = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= 0) {
                int tmp = i;
                while (i <= end && nums[i] >= 0) {
                    rMax += nums[i];
                    i++;
                }
                if (rMax > max) {
                    max = rMax;
                    index[0] = tmp;
                    index[1] = --i;
                }
                rMax = 0;
            }
        }
        return index;
    }

    @Test
    public void testGetMaximalWithRange(){
        int[] nums = new int[]{1, 2, -3, 4, 3, -10, 3};
        int[] minimalRange = getMaximal(nums, 0, 3);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }

        minimalRange = getMaximal(nums, 3, 6);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }

        minimalRange = getMaximal(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }

        minimalRange = getMaximal(nums, 5, 5);
        System.out.println(Arrays.toString(minimalRange));
        for (int i = minimalRange[0]; i <= minimalRange[1]; i++) {
            System.out.println(nums[i]);
        }
    }

    public int help(int[] nums, int start, int end, int pick) {
        if (start < 0 || end == nums.length || pick == 0) {
            return 0;
        }
        int sum;
        int[] minimalRange = getMinimalRange(nums, start, end);
        if (sum(nums, minimalRange[0], minimalRange[1]) >= 0) {
            return sum(nums, start, end);
        }
        if (minimalRange[0] == start && minimalRange[1] == end) {
            return 0;
        }
        if (pick == 1) {
            int[] leftCut = getMaximal(nums, start, minimalRange[0] - 1);
            int[] rightCut = getMaximal(nums, minimalRange[1] + 1, end);
            return Math.max(sum(nums, leftCut[0], leftCut[1]), sum(nums, rightCut[0], rightCut[1]));
        } else {
            int leftHelp = -1;
            int rightHelp = -1;
            if (start <= minimalRange[0] - 1) {
                leftHelp = help(nums, start, minimalRange[0] - 1, pick - 1);
            }
            if (end >= minimalRange[1] + 1) {
                rightHelp = help(nums, minimalRange[1] + 1, end, pick - 1);
            }
            if (leftHelp == -1) {
                sum = help(nums, minimalRange[1] + 1, end, pick);
            } else if (rightHelp == -1) {
                sum = help(nums, start, minimalRange[0] - 1, pick);
            } else {
                sum = leftHelp + rightHelp;
            }
        }
        return sum;
    }

    @Test
    public void test1(){
        int[] nums = new int[]{1, 2, 3, 2, 3, 10, 3};
        assertEquals(0, help(nums, 0, nums.length - 1, 0));
        assertEquals(24, help(nums, 0, nums.length - 1, 1));
        assertEquals(24, help(nums, 0, nums.length - 1, 100));

        nums = new int[]{1, -2, -3, -2, 3, -10, 3};
        assertEquals(3, help(nums, 0, nums.length - 1, 1));
        assertEquals(6, help(nums, 0, nums.length - 1, 2));
        assertEquals(7, help(nums, 0, nums.length - 1, 3));
        assertEquals(7, help(nums, 0, nums.length - 1, 4));
        assertEquals(7, help(nums, 0, nums.length - 1, 100));

        nums = new int[]{100, -2, -3, -2, 3, -10, 3};
        assertEquals(100, help(nums, 0, nums.length - 1, 1));
        assertEquals(103, help(nums, 0, nums.length - 1, 2));
        assertEquals(106, help(nums, 0, nums.length - 1, 3));
        assertEquals(106, help(nums, 0, nums.length - 1, 4));
        assertEquals(106, help(nums, 0, nums.length - 1, 100));

        nums = new int[]{-100, -2, -3, -2, 3, -10, 3};
        assertEquals(3, help(nums, 0, nums.length - 1, 1));
        assertEquals(6, help(nums, 0, nums.length - 1, 2));
        assertEquals(6, help(nums, 0, nums.length - 1, 3));
        assertEquals(6, help(nums, 0, nums.length - 1, 4));
        assertEquals(6, help(nums, 0, nums.length - 1, 100));

        nums = new int[]{-100, -2, -3, -2, -3, -10, -3};
        assertEquals(0, help(nums, 0, nums.length - 1, 1));
        assertEquals(0, help(nums, 0, nums.length - 1, 2));
        assertEquals(0, help(nums, 0, nums.length - 1, 3));
        assertEquals(0, help(nums, 0, nums.length - 1, 4));
        assertEquals(0, help(nums, 0, nums.length - 1, 100));

        nums = new int[]{-100, 2, -100, 3, -100, 4, -100};
        assertEquals(4, help(nums, 0, nums.length - 1, 1));
        assertEquals(7, help(nums, 0, nums.length - 1, 2));
        assertEquals(9, help(nums, 0, nums.length - 1, 3));
        assertEquals(9, help(nums, 0, nums.length - 1, 4));
        assertEquals(9, help(nums, 0, nums.length - 1, 100));
    }

}
