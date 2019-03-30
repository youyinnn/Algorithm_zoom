package leetcode.medium;

/**
 * @author youyinnn
 * Date 3/30/2019
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int dir = 0;
        int count = 2;
        ans[0][0] = 1;
        int[] point = {0, 0};
        while (count <= n * n) {
            if (dir == 0) {
                for (int i = point[1] + 1; i < n; i++) {
                    ans[point[0]][i] = count++;
                    point[1] = i;
                    if (i + 1 < n && ans[point[0]][i + 1] > 0) {
                        break;
                    }
                }
                dir = 1;
            } else if (dir == 1) {
                for (int i = point[0] + 1; i < n; i++) {
                    ans[i][point[1]] = count++;
                    point[0] = i;
                    if (i + 1 < n && ans[i + 1][point[1]] > 0) {
                        break;
                    }
                }
                dir = 2;
            } else if (dir == 2) {
                for (int i = point[1] - 1; i >= 0; i--) {
                    ans[point[0]][i] = count++;
                    point[1] = i;
                    if (i - 1 >= 0 && ans[point[0]][i - 1] > 0) {
                        break;
                    }
                }
                dir = 3;
            } else {
                for (int i = point[0] - 1; i >= 0; i--) {
                    ans[i][point[1]] = count++;
                    point[0] = i;
                    if (i - 1 >= 0 && ans[i - 1][point[1]] > 0) {
                        break;
                    }
                }
                dir = 0;
            }

        }
        return ans;
    }

}
