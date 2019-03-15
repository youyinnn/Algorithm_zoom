package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/14/2019
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int rs;
        if (nums[0] <= nums[nums.length - 1]) {
            rs = Arrays.binarySearch(nums, target);
            return rs < 0 ? -1 : rs;
        }

        int low = 0;
        int high = nums.length - 1;
        int mid;
        // 这段code 别问 问就是不会
        // 8行找到被轴转后的有序数组中的轴位置
        // O(log n)
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (nums[low] <= target && nums[nums.length - 1] >= target) {
            rs = Arrays.binarySearch(nums, low, nums.length, target);
        } else {
            rs = Arrays.binarySearch(nums, 0, low, target);
        }
        return rs < 0 ? -1 : rs;
    }

    @Test
    public void test(){
        search2(new int[]{4,0,1,2,3}, 3);
        search2(new int[]{3,4,0,1,2}, 3);
        search2(new int[]{2,3,4,0,1}, 3);
        search2(new int[]{1,2,3,4,0}, 3);
        search2(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 5);
    }

    @Test
    public void testCase() {
        assertEquals(6, search2(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 3));
        assertEquals(0, search2(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 5));
        assertEquals(7, search2(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 4));
        assertEquals(2, search2(new int[]{5, 6, 7, 0, 1, 2, 3, 4}, 7));
        assertEquals(-1, search2(new int[]{0, 1, 2, 3, 4}, 7));
        assertEquals(2, search2(new int[]{0, 1, 2, 3, 4}, 2));
        assertEquals(4, search2(new int[]{0, 1, 2, 3, 4}, 4));
        assertEquals(0, search2(new int[]{0, 1, 2, 3, 4}, 0));
        assertEquals(-1, search2(new int[]{}, 0));
        assertEquals(-1, search2(new int[]{1}, 0));
        assertEquals(1, search2(new int[]{3,4,5,6,7,1,2}, 4));
        assertEquals(4, search2(new int[]{3,4,5,6,7,1}, 7));
        assertEquals(0, search2(new int[]{3,4,5,6,7,1}, 3));
        assertEquals(5, search2(new int[]{3,4,5,6,7,1}, 1));
        assertEquals(-1, search2(new int[]{3,1}, 0));
        assertEquals(6, search2(new int[]{4,5,6,7,8,9,1,2,3}, 1));
    }
}
