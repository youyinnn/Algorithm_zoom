package leetcode.hard;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/22/2019
 */
public class JumpGameII {

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int lastGood = nums.length - 1;
        int jump = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            // one jump to the end
            if (i + nums[i] >= nums.length - 1) {
                jump = 1;
                lastGood = i;
            } else {
                if (i + nums[i] >= lastGood) {
                    jump += 1;
                    lastGood = i;
                }
            }
        }
        return jump;
    }


    public int jump2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int jump = 0;
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            jump++;
            int tmpEnd = end + 1;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > nums.length) {
                    return jump;
                }
                tmpEnd = Math.max(tmpEnd, i + nums[i]);
            }
            start = end + 1;
            end = tmpEnd;
        }
        return jump;
    }

    @Test
    public void test(){
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 5, 0, 0}));
        System.out.println(jump(new int[]{2, 1, 1, 1}));
    }

    @Test
    public void test2(){
        System.out.println(jump2(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump2(new int[]{2, 5, 0, 0}));
        System.out.println(jump2(new int[]{2, 1, 1, 1}));
    }

}
