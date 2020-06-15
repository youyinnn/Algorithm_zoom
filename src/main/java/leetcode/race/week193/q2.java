package leetcode.race.week193;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Test;

public class q2 {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            Integer v = map.get(arr[i]);
            if (v == null) {
                map.put(arr[i], 0);
                v = 0;
            }
            map.put(arr[i], ++v);
        }
        ArrayList<Integer> count = new ArrayList<>(map.values());
        Collections.sort(count);
        int left = count.size();
        for (int i = 0; i < count.size(); i++) {
            int c = count.get(i);
            if (k >= c) {
                left--;
                k -= c;
            } else {
                return left;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int[] a = {1,1,2,3,3,3,4};
        System.out.println(findLeastNumOfUniqueInts(a, 3));

        int[] b = {5, 5, 4};
        System.out.println(findLeastNumOfUniqueInts(b, 1));
    }
}