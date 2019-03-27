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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        for (int[] rows : matrix) {
            int l = 0, r = rows.length - 1;
            int tmp;
            while (l < r) {
                tmp = rows[r];
                rows[r] = rows[l];
                rows[l] = tmp;
                l++;
                r--;
            }
        }
    }

}
