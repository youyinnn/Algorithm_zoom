package leetcode.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/27/2019
 */
public class NQueens {

    char[] css;

    public List<List<String>> solveNQueens(int n) {
        css = new char[n];
        List<List<String>> ans = new ArrayList<>();
        backtracking(ans, new ArrayList<>(), n, 0);
        return ans;
    }



    private void backtracking(List<List<String>> ans, List<String> cb, int n, int row) {
        if (row == n) {
            ans.add(new ArrayList<>(cb));
        } else {
            for (int i = 0; i < n; i++) {
                if (valid(cb, row, i)) {
                    Arrays.fill(css, '.');
                    css[i] = 'Q';
                    cb.add(String.valueOf(css));
                    backtracking(ans, cb, n, row + 1);
                    cb.remove(cb.size() - 1);
                }
            }
        }
    }

    private boolean valid(List<String> cb, int x, int y) {
        for (int rowIndex = 0; rowIndex < x; rowIndex++) {
            char[] row = cb.get(rowIndex).toCharArray();
            if (row[y] == 'Q') {
                return false;
            }
            int gap = x - rowIndex;
            if (y + gap < row.length && row[y + gap] == 'Q') {
                return false;
            }
            if (y - gap >= 0 && row[y - gap] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private void printCb(List<String> cb) {
        for (String rows : cb) {
            System.out.println(rows);
        }
    }

    @Test
    public void test(){
        List<List<String>> lists = solveNQueens(4);

        for (List<String> list : lists) {
            printCb(list);
            System.out.println("--------");
        }
    }

    @Test
    public void testValid(){
        List<String> cb = new ArrayList<>();
        cb.add("Q....");
        cb.add(".....");
        cb.add(".....");
        cb.add(".....");
        cb.add(".....");

        for (int i = 0; i < cb.size(); i++) {
            char[] cs = cb.get(i).toCharArray();
            for (int j = 0; j < cs.length; j++) {
                System.out.print(valid(cb, i, j)  + "\t");
            }
            System.out.println();
        }
    }

}
