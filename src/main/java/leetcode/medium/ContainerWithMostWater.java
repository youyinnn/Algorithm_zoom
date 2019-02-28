package leetcode.medium;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/28/2019
 */
public class ContainerWithMostWater {

    private int[] h = new int[]{1,8,6,2,5,4,8,3,7};

    public int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (i != j) {
                    int l = Math.min(height[i], height[j]);
                    int w = Math.abs(i - j);
                    ans = Math.max(w * l, ans);
                }
            }
        }
        return ans;
    }

    @Test
    public void test1(){
        System.out.println(maxArea(h));
    }

    public int maxArea2(int[] height) {
        int ans = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int w = r - l;
            System.out.println(height[l] + "," +height[r]);
            if (height[l] > height[r]) {
                ans = Math.max(ans, height[r] * w);
                r--;
            } else {
                ans = Math.max(ans, height[l] * w);
                l++;
            }
        }
        return ans;
    }

    @Test
    public void test2(){
        System.out.println(maxArea2(new int[]{3, 7, 2, 6}));
    }

}
