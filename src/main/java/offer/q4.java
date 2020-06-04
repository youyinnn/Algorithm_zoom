package offer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class q4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int col = matrix[0].length - 1, row = 0;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
        }
        return false;
    }
    
    @Test
    public void t1() {
        int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
          };
        assertEquals(true, findNumberIn2DArray(matrix, 13));            
        assertEquals(false, findNumberIn2DArray(matrix, 25));            
        assertEquals(false, findNumberIn2DArray(matrix, 99));            
        assertEquals(true, findNumberIn2DArray(matrix, 30));            
    }
    
    @Test
    public void t2() {
        int[][] matrix = {{1}};
        assertEquals(false, findNumberIn2DArray(matrix, 13));            
    }

    @Test
    public void t3() {
        int[][] matrix = {{1, 3}};
        assertEquals(true, findNumberIn2DArray(matrix, 3));            
    }
}