package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 4/2/2019
 */
public class MinimunPathSum {

    int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
    };

    int ans = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        backtracking(grid, 0, 0, 0);
        return ans;
    }

    public void backtracking(int[][] grid, int tempSum, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            ans = Math.min(tempSum + grid[x][y], ans);
        } else if (grid.length > 0 && grid[0].length > 0){
            tempSum += grid[x][y];
            if (x < grid.length - 1) {
                backtracking(grid, tempSum, x + 1, y);
            }
            if (y < grid[0].length - 1) {
                backtracking(grid, tempSum, x, y + 1);
            }
        } else {
            ans = 0;
        }
    }

    @Test
    public void test(){
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum(new int[][]{{0,1},{0,1}}));
        System.out.println(minPathSum(new int[][]{}));
        System.out.println(minPathSum(new int[][]{{},{1}}));
    }

    public int minPathSum2(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] pre = new int[grid[0].length];
        int[] now = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    now[0] = grid[0][0];
                } else if (i == 0) {
                    now[j] = grid[0][j] + now[j - 1];
                } else if (j == 0) {
                    now[j] = grid[i][0] + pre[j];
                } else {
                    now[j] = grid[i][j] + Math.min(now[j - 1], pre[j]);
                }
            }
            pre = Arrays.copyOf(now, now.length);
        }
        return now[now.length - 1];
    }

    @Test
    public void test2(){
        System.out.println(minPathSum2(grid));
        System.out.println(minPathSum2(new int[][]{{0,1},{0,1}}));
        System.out.println(minPathSum2(new int[][]{}));
        System.out.println(minPathSum2(new int[][]{{},{1}}));
    }

}
