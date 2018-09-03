package algorithm;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 9/2/2018
 */
public class MaximumSubArrayTest {

    @Test
    public void testMs1() {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = new int[]{-2, -1, -3, -4, -1, -2, -1, -5, -4};
        int[] arr3 = new int[]{1};
        //System.out.println(ms(arr));
        //System.out.println(ms2(arr2));
        System.out.println(ms3(arr));
        System.out.println(ms3(arr2));
        System.out.println(ms3(arr3));
    }

    /**
     * O(n^2) 的暴力解
     * @param nums
     * @return
     */
    private int ms(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int rSum = 0;
            for (int j = i; j < nums.length; j++) {
                rSum += nums[j];
                max = max > rSum ? max : rSum;
            }
        }
        return max;
    }

    /**
     * 改编自《数据结构与算法分析Java语言描述》
     * 参考：https://www.cnblogs.com/blackiesong/p/6076389.html
     * @param nums
     * @return
     */
    private int ms2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int rSum = 0;
        int maxOne = nums[0];
        for (int num : nums) {
            maxOne = maxOne > num ? maxOne : num;
            rSum += num;
            rSum = rSum < 0 ? 0 : rSum;
            max = rSum > max ? rSum : max;
        }
        return max == 0 ? maxOne : max;
    }

    /**
     * DP解法
     * 参考自：https://blog.csdn.net/zwzsdy/article/details/80029796
     *        https://www.cnblogs.com/coderJiebao/p/Algorithmofnotes27.html
     * @param nums
     * @return
     */
    private int ms3(int[] nums) {
        int max = nums[0];
        int dp  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] > dp + nums[i] ? nums[i] : dp + nums[i];
            max = max > dp ? max : dp;
        }
        return max;
    }

}
