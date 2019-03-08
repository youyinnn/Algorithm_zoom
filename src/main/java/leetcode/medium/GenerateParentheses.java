package leetcode.medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/8/2019
 */
public class GenerateParentheses {

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        LinkedList<String> ans = new LinkedList<>();
        return get(ans, "", 0, 0 ,n);
    }

    private List<String> get(List<String> ans, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            ans.add(str);
        } else {
            if (open < n) {
                get(ans, str + "(", open + 1, close, n);
            }
            if (close < open) {
                get(ans, str + ")", open, close + 1, n);
            }
        }
        return ans;
    }

}
