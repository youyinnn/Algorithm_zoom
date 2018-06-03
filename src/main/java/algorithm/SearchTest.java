package algorithm;

import org.junit.Test;

/**
 * @author youyinnn
 */
public class SearchTest {

    public static int dynamicBinarySearch(int[] arr, int start, int end, int target) {
        int low = start, high = end, mid;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -low;
    }

    @Test
    public void testStaticBinarySearch(){
        int[] arr = {1,2,3,5,6,7,8};
        System.out.println(dynamicBinarySearch(arr,0, arr.length - 1, 4));
    }

}
