package leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/20/2019
 */
public class TrappingRainWater {


    public int trap(int[] height) {
        int count = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            while (height[left] == 0) {
                left++;
                if (left == height.length - 1) {
                    break;
                }
            }
            while (height[right] == 0) {
                right--;
                if (right == 0) {
                    break;
                }
            }
            int min = height[left];
            for (int i = left + 1; i <= right; i++) {
                int num = height[i];
                if (num > 0) {
                    min = Math.min(num, min);
                }
            }
            for (int i = left; i <= right; i++) {
                int num = height[i];
                if (num > 0) {
                  height[i] -= min;
                } else if (num == 0) {
                    count += min;
                }
            }
        }
        return count;
    }

    @Test
    public void test(){
        assertEquals(1, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(1, trap(new int[]{2,0,2}));
    }


    public int trap2(int[] height) {
        int count = 0;
        for (int i = 0; i < height.length - 1;) {
            int l = height[i];
            if (l > 0) {
                int ri = i + 1;
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] > l) {
                        ri = j;
                        break;
                    } else {
                        ri = height[j] > height[ri] ? j : ri;
                    }
                }
                int length = Math.min(l, height[ri]);
                int trap = 0;
                for (int j = i + 1; j < ri; j++) {
                    trap += length - height[j];
                }
                count += trap;
                i = ri;
            } else {
                i++;
            }
        }
        return count;
    }

    @Test
    public void test2(){
        assertEquals(6, trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 99}));
        assertEquals(2, trap2(new int[]{2,0,2}));
        assertEquals(1, trap2(new int[]{4,2,3}));
        assertEquals(4, trap2(new int[]{9,8,2,6}));
        assertEquals(1, trap2(new int[]{4,9,4,5,3,2}));
    }
}
