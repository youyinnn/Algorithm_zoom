package algorithm;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 9/3/2018
 */
public class RobotAndCellTest {

    @Test
    public void test(){
        System.out.println(countWays(2, 2));
        System.out.println(countWaysMemo(2, 2));
        System.out.println(countWaysDp(2, 2));
    }

    private int countWays(int x, int y) {
        if (x == 0 || y == 0) {
            return 0;
        } else if (x == 1 || y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }

    private int countWaysMemo(int x, int y) {
        int[][] memo = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    memo[i][j] = 1;
                } else {
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[x - 1][y - 1];
    }

    private int countWaysDp(int x, int y) {
        int[] pre = new int[x];
        int[] now = new int[x];
        for (int i = 1; i < x; i++) {
            pre[i] = 1;
        }
        for (int i = 1; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (j == 0) {
                    now[j] = 1;
                } else {
                    now[j] = now[j - 1] + pre[j];
                }
            }
            System.arraycopy(now, 0, pre, 0, x);
        }
        return now[x - 1];
    }
}
