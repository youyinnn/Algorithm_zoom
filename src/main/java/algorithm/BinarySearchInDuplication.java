package algorithm;

import org.junit.Test;

public class BinarySearchInDuplication {
    
    public int search(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] == target) {
                while (mid > 0 && a[mid] == a[mid - 1]) mid--;
                return mid;
            } else if (a[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return a[l] == target ? l : -1;
    }

    @Test
    public void t1() {
        System.out.println(search(new int[]{1,2,3,3,3,4,5}, 3));    
        System.out.println(search(new int[]{1,2,4,5}, 3));    
        System.out.println(search(new int[]{1,3,3,3,5}, 3));    
        System.out.println(search(new int[]{3,3,3}, 3));    
        System.out.println(search(new int[]{1,2,3,3,3}, 3));    
        System.out.println(search(new int[]{1,3,3,3}, 3));    
    }
}