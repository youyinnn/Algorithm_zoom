package leetcode.medium;

import java.util.List;

import org.junit.Test;

import java.util.ArrayList;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() > 0) back(s, 0, new ArrayList<String>(), ans);
        return ans;
    }
    
    public void back(String s, int start, ArrayList<String> tmp, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                tmp.add(s.substring(start, i + 1));
                back(s, i + 1, tmp, ans);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    @Test
    public void t1() {
        System.out.println(partition("aab"));
    }
}