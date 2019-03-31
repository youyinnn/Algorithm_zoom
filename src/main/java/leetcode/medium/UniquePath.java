package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/31/2019
 */
public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] now = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                now[j] = j > 0 ? (now[j - 1] + pre[j]) : 1;
            }
            pre = Arrays.copyOf(now, now.length);
        }
        return now[n - 1];
    }

    @Test
    public void test(){
        System.out.println(uniquePaths(1, 2));
        System.out.println(uniquePaths(7, 3));
    }

}
