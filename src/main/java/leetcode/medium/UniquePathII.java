package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/31/2019
 */
public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] pre = new int[n];
        if (obstacleGrid[0][0] != 1) {
            pre[0] = 1;
            for (int i = 1; i < pre.length; i++) {
                if (obstacleGrid[0][i] != 0) {
                    pre[i] = 1;
                } else {
                    break;
                }
            }
        }
        int[] now = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    now[j] = 0;
                } else {
                    now[j] = j > 0 ? (now[j - 1] + pre[j]) : pre[j];
                }
            }
            pre = Arrays.copyOf(now, now.length);
        }
        return now[n - 1];
    }

    int[][] ob = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
    };

    int[][] ob2 = {
            {0,0,0},
            {0,0,0},
            {0,0,0}
    };

    @Test
    public void test(){
        assertEquals(2, (uniquePathsWithObstacles(ob)));
        assertEquals(6, uniquePathsWithObstacles(ob2));
        assertEquals(0, uniquePathsWithObstacles(new int[][]{{1}}));
        assertEquals(0, uniquePathsWithObstacles(new int[][]{{0},{0},{0},{0},{1}}));
        assertEquals(0, uniquePathsWithObstacles(new int[][]{{1},{0},{0},{0},{0}}));
    }
}
