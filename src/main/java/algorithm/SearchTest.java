package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

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

    static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length, mid;
        int get = -1;
        if (high == 1) {
            if (a[0] == key) {
                get = 0;
            }
        } else {
            while (low <= high) {
                mid = (low + high) >>> 1;
                if (a[mid] < key) {
                    low = mid + 1;
                } else if (a[mid] > key) {
                    high = mid - 1;
                } else {
                    high = mid - 1;
                    get = mid;
                }
            }
        }
        return get;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = Arrays.stream(input.nextLine().replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();
        int val = Integer.parseInt(input.nextLine());
        System.out.print(binarySearch(array, val));
    }
}
