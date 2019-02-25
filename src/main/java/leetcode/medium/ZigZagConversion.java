package leetcode.medium;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 2/21/2019
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int rowsCount = 1;
        StringBuilder sb = new StringBuilder();
        int mainGap = (numRows - 1) * 2;
        while (rowsCount <= numRows) {
            int start = rowsCount - 1;
            int minorGap = (numRows - rowsCount) * 2;
            for (int i = start; i < chars.length; i += mainGap) {
                sb.append(chars[i]);
                if (minorGap < mainGap
                        && rowsCount < numRows
                        && i + minorGap < chars.length) {
                    sb.append(chars[i + minorGap]);
                }
            }
            rowsCount++;
        }
        return sb.toString();
    }

    @Test
    public void testConvert(){
        String target = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println(convert(target, 5));
        System.out.println(convert(target, 3));
        System.out.println(convert(target, 2));
    }

}
