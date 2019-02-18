package leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 2/16/2019
 */
public class MedianOfTwoSortedArrays {

    int[] nums1;
    int[] nums2;

    @Before
    public void set() {
        nums1 = new int[]{1, 8, 20, 55, 77};
        nums2 = new int[]{2, 4, 5, 9, 23, 27, 85, 152, 964};
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }
        int lengthSum = nums1.length + nums2.length;
        int mi = lengthSum / 2;
        int p1 = 0, p2 = 0;
        int[] tar = new int[mi + 1];
        for (int i = 0 ; i <= mi; i++) {
            if (p1 == nums1 .length) {
                tar[i] = nums2[p2];
                continue;
            }
            if (p1 <= nums1.length - 1 && p2 <= nums2.length - 1) {
                if (nums1[p1] > nums2[p2]) {
                    tar[i] = nums2[p2];
                    p2++;
                } else if (nums1[p1] < nums2[p2]) {
                    tar[i] = nums1[p1];
                    p1++;
                } else {
                    tar[i++] = nums1[p1];
                    if (i < tar.length) {
                        tar[i] = nums1[p1];
                    }
                    p1++;
                    p2++;
                }
            } else {
                tar[i] = nums1[p1];
                p1++;
            }
        }
        if (lengthSum % 2 == 0) {
            double a = tar[tar.length - 1];
            double b = tar[tar.length - 2];
            return (a + b) / 2;
        } else {
            return tar[tar.length - 1];
        }
    }

    @Test
    public void test1(){
        System.out.println(findMedianSortedArrays1(nums1, nums2));
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // to ensure m<=n
        if (m > n) {
            return findMedianSortedArrays2(B, A);
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                // i is too small
                iMin = i + 1;
            } else if (i > iMin && A[i-1] > B[j]) {
                // i is too big
                iMax = i - 1;
            } else {
                // i is perfect
                showCut(A, i);
                showCut(B, j);
                int maxLeft;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }

                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                System.out.println(maxLeft);
                System.out.println(minRight);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    @Test
    public void test2() {
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public void showCut(int[] arr, int cutIndex) {
        int[] leftPart = new int[cutIndex];
        int[] rightPart = new int[arr.length - cutIndex];
        System.arraycopy(arr, 0, leftPart, 0, cutIndex);
        System.arraycopy(arr, cutIndex, rightPart, 0, arr.length - cutIndex);
        System.out.println("cut:" + cutIndex + " --> " + Arrays.toString(leftPart) + " | " + Arrays.toString(rightPart));
    }
}
