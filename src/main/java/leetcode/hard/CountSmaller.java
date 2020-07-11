package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    
    int[] tmp;
    int[] index;
    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        tmp   = new int[nums.length];
        index = new int[nums.length];
        count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSortForIndex(nums, 0, nums.length - 1);
        List<Integer> ans = new ArrayList<>();
        for (int n: count) ans.add(n);
        return ans;
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
}