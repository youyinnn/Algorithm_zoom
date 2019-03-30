package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/29/2019
 */
public class NQueensII {

    int ans = 0;

    public int totalNQueens(int n) {
        backtracking(new ArrayList<>(), n, 0);
        return ans;
    }

    private void backtracking(List<String> cb, int n, int row) {
        if (row == n) {
            ans++;
        } else {
            for (int i = 0; i < n; i++) {
                if (valid(cb, row, i)) {
                    char[] css = new char[n];
                    Arrays.fill(css, '.');
                    css[i] = 'Q';
                    cb.add(String.valueOf(css));
                    backtracking(cb, n, row + 1);
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

}
