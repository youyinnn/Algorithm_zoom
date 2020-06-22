package leetcode.race.week194;

import org.junit.Test;

public class q1 {
    
    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = start + 2 * i;
        }
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    @Test
    public void t1() {
        
    }
}