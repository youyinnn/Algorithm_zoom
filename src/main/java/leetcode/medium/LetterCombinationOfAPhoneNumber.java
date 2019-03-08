package leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/8/2019
 */
public class LetterCombinationOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));
    }

    private static char[][] map = {
            {}, // 0
            {}, // 1
            {'a','b','c'},  // 2
            {'d','e','f'},  // 3
            {'g','h','i'},  // 4
            {'j','k','l'},  // 5
            {'m','n','o'},  // 6
            {'p','q','r','s'}, // 7
            {'t','u','v'},  // 8
            {'w','x','y','z'}, // 9
    };

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        char[] chars = digits.toCharArray();
        return get(chars, 0, chars.length - 1);
    }

    private static List<String> get(char[] set, int start, int end) {
        LinkedList<String> ans = new LinkedList<>();
        if (start == end) {
            char[] mapping = mapping(set[start]);
            for (char c : mapping) {
                ans.add(String.valueOf(c));
            }
        } else if (end - start == 1) {
            char[] sm = mapping(set[start]);
            char[] em = mapping(set[end]);
            for (char aSm : sm) {
                for (char anEm : em) {
                    ans.add(aSm + String.valueOf(anEm));
                }
            }
        } else {
            List<String> a = get(set, start, start + 1);
            List<String> b = get(set, start + 2, end);
            for (String as : a) {
                for (String bs : b) {
                    ans.add(as + bs);
                }
            }
        }
        return ans;
    }

    private static char[] mapping(char digitalChar) {
        return map[digitalChar - '0'];
    }
}
