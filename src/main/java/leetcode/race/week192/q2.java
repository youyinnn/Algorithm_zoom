package leetcode.race.week192;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class q2 {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        Integer[] nArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nArr[i] = arr[i];
        }
        Arrays.sort(nArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1 - m) > Math.abs(o2 - m)) || 
                ((o1 > o2) && (Math.abs(o1 - m) == Math.abs(o2 - m))) ? -1 : 1;
            }
            
        });
        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nArr[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(getStrongest(a, 2)));

        int[] b = {1,1,3,5,5};
        System.out.println(Arrays.toString(getStrongest(b, 2)));        
        
        int[] c = {6,7,11,7,6,8};
        System.out.println(Arrays.toString(getStrongest(c, 5)));
    }
}