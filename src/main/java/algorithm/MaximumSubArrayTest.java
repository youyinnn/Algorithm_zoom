package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
        //System.out.println(ms3(arr2));
        //System.out.println(ms3(arr3));
    }

    @Test
    public void testMsArray(){
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4, 1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(1,2,3,-9,7));
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(-1,-2,3,9,-100));
        ArrayList<Integer> arr4 = new ArrayList<>(Arrays.asList(1000, -4));
        //System.out.println(ms(arr1));
        //System.out.println(ms3(arr1));
        //System.out.println(ms(arr2));
        //System.out.println("---------------------------");
        //System.out.println(ms(arr1));
        //System.out.println(ms(arr2));
        //System.out.println(ms(arr3));
        //System.out.println(ms(arr4));
        System.out.println(ms3(arr1));
        System.out.println(ms3(arr2));
        System.out.println(ms3(arr3));
        System.out.println(ms3(arr4));
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
     * 暴力解变种，可以记录最大子序列的左右下标范围
     *
     * @param nums
     * @return
     */
    private int ms(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        int bg = 0;
        int end = 0;
        for (int i = 0; i < nums.size(); i++) {
            int rSum = 0;
            for (int j = i; j < nums.size(); j++) {
                rSum += nums.get(j);
                if (max < rSum) {
                    bg = i;
                    end= j;
                    max = rSum;
                }
            }
        }
        clearArr(nums, bg, end);
        return max;
    }

    private void clearArr(ArrayList<Integer> nums, int bg, int end) {
        for (int i = 0; i < end - bg + 1; i++) {
            nums.remove(bg);
        }
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
        int rMax  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            rMax = nums[i] > rMax + nums[i] ? nums[i] : rMax + nums[i];
            max = max > rMax ? max : rMax;
        }
        return max;
    }

    private int ms3(ArrayList<Integer> nums) {
        int max = nums.get(0);
        int rMax  = nums.get(0);
        int bg = 0;
        int end = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > rMax + nums.get(i)) {
                rMax = nums.get(i);
                bg = i;
            } else {
                rMax = rMax + nums.get(i);
            }
            if (max < rMax) {
                end = i;
                max = rMax;
            }
        }
        clearArr(nums, bg, end);
        return max;
    }

}
