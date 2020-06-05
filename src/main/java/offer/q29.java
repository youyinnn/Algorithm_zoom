package offer;

import java.util.Arrays;

import org.junit.Test;

public class q29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null) return null;
        if (matrix.length == 0) return new int[0];
        int row = matrix.length, col = matrix[0].length;
        int start = 0;
        int[] ans = new int[row * col];
        int count = 0;
        while (col > start * 2 && row > start * 2) {
            count = round(matrix, col, row, start++, ans, count);
        }
        return ans;
    }

    private int round(int[][] matrix, int col, int row, int start, int[] ans, int count) {
        int endY = row - start - 1;
        int endX = col - start - 1;

        for (int i = start; i <= endX; i++) {
            ans[count++] = matrix[start][i];
        }

        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                ans[count++] = matrix[i][endX];
            }
        }

        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                ans[count++] = matrix[endY][i];
            }
        }

        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                ans[count++] = matrix[i][start];
            }
        }
        return count;
    }

    int[][] matrix = {
        {0,1,2,3,4},
        {5,6,7,8,9},
        {10,11,12,13,14},
        {15,16,17,18,19}
    };

    int[][] matrix2 = {
        {1,2,3},
        {4,5,6},
        {7,8,9},
    };

    int[][] matrix3 = {
        {1,2,3}
    };    
    
    int[][] matrix4 = {
        {1},
        {2},
        {3}
    };    
    
    int[][] matrix5 = {
        {1}
    };    

    int[][] matrix6 = {
        {}
    };    
    
    int[][] matrix7 = {
    };

    @Test
    public void t1() {
        System.out.println(Arrays.toString(spiralOrder(matrix)));
        System.out.println(Arrays.toString(spiralOrder(matrix2)));
        System.out.println(Arrays.toString(spiralOrder(matrix3)));
        System.out.println(Arrays.toString(spiralOrder(matrix4)));
        System.out.println(Arrays.toString(spiralOrder(matrix5)));
        System.out.println(Arrays.toString(spiralOrder(matrix6)));
        System.out.println(Arrays.toString(spiralOrder(matrix7)));
    }
}