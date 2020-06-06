package leetcode.hard;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();   
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int head : nums) {
            if (!set.contains(head - 1)) {
                int currentLongest = 1;
                while (set.contains(++head)) {
                    currentLongest++;
                }                
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

    @Test
    public void t1() {
        int[] a = {100, 4, 200, 1, 3, 2};
        assertEquals(4, longestConsecutive(a));
        int[] b = {100};
        assertEquals(1, longestConsecutive(b));        
        int[] c = {};
        assertEquals(0, longestConsecutive(c));
        int[] d = {5,4,3,2,1};
        assertEquals(5, longestConsecutive(d));
    }

}