package leetcode.medium;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author youyinnn
 * Date 3/19/2019
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            char[] row = board[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                char number = row[columnIndex];
                if (number != '.') {
                    for (int col = 0; col < row.length; col++) {
                        // duplicate in same row
                        if (col != columnIndex && row[col] == number) {
                            return false;
                        }
                    }
                    for (int ro = 0; ro < row.length; ro++) {
                        // duplicate in same column
                        if (ro != rowIndex && board[ro][columnIndex] == number) {
                            return false;
                        }
                    }
                    int rowFactor = rowIndex / 3;
                    int colFactor = columnIndex / 3;
                    // duplicate in 3x3
                    for (int rs = rowFactor * 3; rs < (rowFactor * 3) + 3; rs++) {
                        for (int cs = colFactor * 3; cs < (colFactor * 3) + 3; cs++) {
                            if (rs != rowIndex && cs != columnIndex && board[rs][cs] == number) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    char[][] board1 = new char[][]{
            {'5','3','.',  '.','7','.',  '.','.','.'},
            {'6','.','.',  '1','9','5',  '.','.','.'},
            {'.','9','8',  '.','.','.',  '.','6','.'},

            {'8','.','.',  '.','6','.',  '.','.','3'},
            {'4','.','.',  '8','.','3',  '.','.','1'},
            {'7','.','.',  '.','2','.',  '.','.','6'},

            {'.','6','.',  '.','.','.',  '2','8','.'},
            {'.','.','.',  '4','1','9',  '.','.','5'},
            {'.','.','.',  '.','8','.',  '.','7','9'}};

    @Test
    public void test(){
        System.out.println(isValidSudoku(board1));
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> proposition = new HashSet<>();
        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            char[] row = board[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                char number = row[columnIndex];
                if (number != '.') {
                    int rowFactor = rowIndex / 3;
                    int colFactor = columnIndex / 3;
                    if (!proposition.add(number + "-r-" + rowIndex) ||
                            !proposition.add(number + "-c-" + columnIndex) ||
                            !proposition.add(number + "-3x3-" + rowFactor + "-" + colFactor)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
