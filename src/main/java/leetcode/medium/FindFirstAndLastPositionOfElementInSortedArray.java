package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/17/2019
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int search = Arrays.binarySearch(nums, target);
        if (search < 0) {
            return new int[]{-1, -1};
        } else {
            int first = search - 1;
            while (first >= 0 && nums[first] == target) {
                first--;
            }
            int last = search + 1;
            while (last < nums.length && nums[last] == target) {
                last++;
            }
            return new int[]{first + 1, last - 1};
        }
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{1,1,2}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[Integer.MAX_VALUE / 1024], 0)));
    }

    public int[] searchRange2(int[] nums, int target) {
        int search = Arrays.binarySearch(nums, target);
        if (search < 0) {
            return new int[]{-1, -1};
        } else {
            int first = search, tmpFirst = search;
            while (tmpFirst >= 0) {
                tmpFirst = Arrays.binarySearch(nums, 0, tmpFirst, target);
                if (tmpFirst >= 0) {
                    first = tmpFirst;
                }
            }
            int last = search, tmpLast = search;
            while (tmpLast >= 0 && tmpLast < nums.length) {
                tmpLast = Arrays.binarySearch(nums, tmpLast + 1, nums.length, target);
                if (tmpLast >= 0) {
                    last = tmpLast;
                }
            }
            return new int[]{first, last};
        }
    }

    @Test
    public void test2(){
        System.out.println(Arrays.toString(searchRange2(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange2(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange2(new int[]{1,1,2}, 1)));
        System.out.println(Arrays.toString(searchRange2(new int[] {-1,0,0,0,0}, 0)));
        System.out.println(Arrays.toString(searchRange2(new int[] {-1,0,0,0,0}, 3)));
    }

}
