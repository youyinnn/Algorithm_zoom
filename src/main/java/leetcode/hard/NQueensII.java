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

    boolean[] colSet, drSet, dlSet;

    public int totalNQueens2(int n) {
        colSet = new boolean[n];
        drSet = new boolean[n * 2];
        dlSet = new boolean[n * 2];
        backtracking(n, 0);
        return ans;
    }

    private void backtracking(int n, int row) {
        if (row == n) {
            ans++;
        } else {
            for (int col = 0; col < n; col++) {
                int dli = col - row + n;
                int dri = col + row;
                if (colSet[col] || drSet[dri] || dlSet[dli]) {
                    continue;
                }
                colSet[col] = drSet[dri] = dlSet[dli] = true;
                backtracking(n, row + 1);
                colSet[col] = drSet[dri] = dlSet[dli] = false;
            }
        }
    }

}
