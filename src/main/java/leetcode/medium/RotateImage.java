package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author youyinnn
 * Date 3/23/2019
 */
public class RotateImage {

    @Test
    public void test(){
        int[][] matrix = new int[][]
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };

        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

        matrix = new int[][]
                {
                        { 5, 1, 9,11},
                        { 2, 4, 8,10},
                        {13, 3, 6, 7},
                        {15,14,12,16}
                };

        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

        matrix = new int[][]
                {
                        { 1,  2,  3,  4,  5},
                        { 6,  7,  8,  9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19 ,20},
                        {21, 22, 23, 24, 25}
                };

        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    @Test
    public void test2(){
        int[][] matrix = new int[][]
                {
                        {1,2},
                        {3,4}
                };

        rotate(matrix);

        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public void rotate(int[][] matrix) {
        int gap = matrix.length - 1;
        int row = 0;
        int col = 0;
        while (gap >= 1) {
            int start = row;
            int end = row + gap;
            for (int i = col; i < col + gap; i++) {
                int[] tmp = new int[]{row, i};
                int[] swap;
                int old = matrix[tmp[0]][tmp[1]];
                while (true){
                    swap = swap(matrix, tmp[0], tmp[1], start, end, gap);
                    int tmpOld = matrix[swap[0]][swap[1]];
                    matrix[swap[0]][swap[1]] = old;
                    old = tmpOld;
                    tmp = swap;
                    if (swap[0] == row && swap[1] == i) {
                        break;
                    }
                }
            }
            gap -= 2;
            row++;
            col++;
        }
    }

    public int[] swap(int[][] matrix, int row, int col, int start, int end, int gap) {
        int newCol = col;
        int newRow = row;
        if (row == start) {
            if (col + gap > end) {
                // right down
                newRow = row + (col + gap - end);
                newCol = end;
            } else {
                // just right
                newCol = col + gap;
            }
        } else if (col == end) {
            if (row + gap > end) {
                // down left
                newCol = end - (row + gap - end);
                newRow = end;
            } else {
                // just down
                newRow = row + gap;
            }
        } else if (col == start) {
            if (row - gap < start) {
                // up right
                newCol = col - (row - gap);
                newRow = start;
            } else {
                // just up
                newRow = row - gap;
            }
        } else if (row == end) {
            if (col - gap < start) {
                // left up
                newRow = row + (col - gap);
                newCol = start;
            } else {
                // just left
                newCol = col - gap;
            }
        }
        return new int[]{newRow, newCol};
    }

    @Test
    public void testSwap(){
        int[][] ma = new int[][] {
                {0,1,0,2},
                {5,0,0,0},
                {0,0,0,3},
                {4,0,0,0}
        };

        swap(ma, 0, 1, 0, 3, 3);
        swap(ma, 0, 3, 0, 3, 3);
        swap(ma, 2, 3, 0, 3, 3);
        swap(ma, 3, 0, 0, 3, 3);
        swap(ma, 1, 0, 0, 3, 3);

        for (int[] ints : ma) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
