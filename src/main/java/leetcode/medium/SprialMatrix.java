package leetcode.medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/27/2019
 */
public class SprialMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (matrix.length == 0) {
            return ans;
        }
        int[] range = new int[]{1, matrix[0].length - 1, matrix.length - 1, 0};
        int[] point = new int[]{0, 0};
        int rangeIndex = 1;
        int rowOrCol = 1;
        ans.add(matrix[0][0]);
        while (ans.size() < matrix.length * matrix[0].length) {
            int nowRange = range[rangeIndex];
            int nowDir;
            if (rowOrCol == 1) {
                // col
                nowDir = point[1];
                if (nowDir > nowRange) {
                    for (int i = nowDir - 1; i >= nowRange; i--) {
                        ans.add(matrix[point[0]][i]);
                    }
                    point[1] = nowRange;
                    range[rangeIndex] += 1;
                } else {
                    for (int i = nowDir + 1; i <= nowRange; i++) {
                        ans.add(matrix[point[0]][i]);
                    }
                    point[1] = nowRange;
                    range[rangeIndex] -= 1;
                }
                rowOrCol = 0;
            } else {
                // row
                nowDir = point[0];
                if (nowDir > nowRange) {
                    for (int i = nowDir - 1; i >= nowRange; i--) {
                        ans.add(matrix[i][point[1]]);
                    }
                    point[0] = nowRange;
                    range[rangeIndex] += 1;
                } else {
                    for (int i = nowDir + 1; i <= nowRange; i++) {
                        ans.add(matrix[i][point[1]]);
                    }
                    point[0] = nowRange;
                    range[rangeIndex] -= 1;
                }
                rowOrCol = 1;
            }
            rangeIndex = nextRange(rangeIndex);
        }
        return ans;
    }

    private int nextRange(int i) {
        return i + 1 < 4 ? i + 1 : 0;
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

    @Test
    public void test(){
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(new int[][]{}));
    }

}
