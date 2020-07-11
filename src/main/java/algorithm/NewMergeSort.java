package algorithm;

import java.util.Arrays;

import org.junit.Test;

public class NewMergeSort {

    int[] index;
    int[] tmp;

    public int[] sortArray(int[] nums) {
        tmp = new int[nums.length];
        index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start >> 1);

        int bi = start,   bEnd = mid;
        int ci = mid + 1, cEnd = end;

        mergeSort(arr, bi, bEnd);
        mergeSort(arr, ci, cEnd);

        if (arr[mid] <= arr[mid + 1]) return;

        for (int i = start; i <= end; i++) {
            tmp[i] = index[i];
        }

        int ti = start;
        while (bi <= bEnd && ci <= cEnd) {
            if (arr[bi] <= arr[ci]) {
                tmp[ti++] = arr[bi++];
            } else {
                tmp[ti++] = arr[ci++];
            }
        }
        while (bi <= bEnd) {
            tmp[ti++] = arr[bi++];
        }
        while (ci <= cEnd) {
            tmp[ti++] = arr[ci++];
        }

        for (ti = start; ti <= end; ti++) {
            arr[ti] = tmp[ti];
        }
    }

    @Test
    public void t1() {
        int[] a = new int[]{7,5,6,4,8,3,2,6,0,9,5,2};
        sortArray(a);
        System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(index));
    }

    int[] count;

    public void sortArrayForIndex(int[] nums) {
        tmp   = new int[nums.length];
        index = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSortForIndex(nums, 0, nums.length - 1);
    }

    public void mergeSortForIndex(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start >> 1);

        int bi = start,   bEnd = mid;
        int ci = mid + 1, cEnd = end;

        mergeSortForIndex(arr, bi, bEnd);
        mergeSortForIndex(arr, ci, cEnd);

        if (arr[index[mid]] <= arr[index[mid + 1]]) return;

        for (int i = start; i <= end; i++) {
            tmp[i] = index[i];
        }

        int ii = start;
        while (bi <= bEnd && ci <= cEnd) {
            if (arr[tmp[bi]] <= arr[tmp[ci]]) {
                index[ii] = tmp[bi];
                count[index[ii]] += (ci - mid - 1);
                ii++;
                bi++;
            } else {
                index[ii++] = tmp[ci++];
            }
        }
        while (bi <= bEnd) {
            index[ii] = tmp[bi];
            count[index[ii]] += (end - mid);
            ii++;
            bi++;
        }
        while (ci <= cEnd) {
            index[ii++] = tmp[ci++];
        }
    }

    @Test
    public void t2() {
        int[] a = new int[]{7,5,6,4,8,3,2,6,0,9,5,2};
        sortArrayForIndex(a);
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < index.length; i++) {
            System.out.print(a[index[i]] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(new int[]{9,5,6,4,6,3,1,3,0,2,1,0}));
    }
}