package leetcode.easy;

import org.junit.Test;

/**
 * @author youyinnn
 * Date 3/2/2019
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String flag = strs[0];
        boolean stop = false;
        for (int i = 0; i < flag.length() && !stop; i++) {
            char flagP = flag.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String next = strs[j];
                if (next.length() - 1 < i || next.charAt(i) != flagP) {
                    stop = true;
                }
            }
            if (!stop) {
                stringBuilder.append(flagP);
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test1(){
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa","a"}));
    }

}
