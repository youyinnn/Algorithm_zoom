package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author youyinnn
 * Date 3/27/2019
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ansMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new LinkedList<>());
            }
            ansMap.get(key).add(str);
        }
        return new LinkedList<>(ansMap.values());
    }

}
