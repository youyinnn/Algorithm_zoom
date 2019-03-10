package leetcode.hard;

import org.junit.Test;

import java.util.*;

/**
 * The type Sub string with concatenation of all words.
 *
 * @author youyinnn  Date 3/9/2019
 */
public class SubStringWithConcatenationOfAllWords {

    /**
     * Test.
     */
    @Test
    public void test(){
        String[] words = {"word", "good", "best", "good"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword", words));
    }

    @Test
    public void test3(){
        String[] words = {"a"};
        System.out.println(findSubstring("a", words));
    }

    @Test
    public void test4(){
        String[] words = {"is"};
        System.out.println(findSubstring("mississippi", words));
    }

    /**
     * Find substring list.
     *
     * @param s     the s
     * @param words the words
     * @return the list
     */
    public List<Integer> findSubstring(String s, String[] words) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (words.length == 0) {
            return ans;
        }
        int wordLength = words[0].length();
        HashMap<String, Integer> countMap = new HashMap<>(words.length);
        int count = 0;
        for (String word : words) {
            Integer integer = countMap.get(word);
            if (integer != null) {
                countMap.put(word, ++integer);
            } else {
                countMap.put(word, 1);
            }
            count++;
        }

        for (int i = 0; i < s.length() - wordLength + 1; i++) {
            String first = s.substring(i, i + wordLength);
            Integer firstCount = countMap.get(first);
            int tmpCount = count;
            if (firstCount != null) {
                HashMap<String, Integer> tmp = (HashMap<String, Integer>) countMap.clone();
                tmp.put(first, --firstCount);
                tmpCount--;
                int tmpI = i;
                do {
                    if (tmpCount == 0) {
                        ans.add(i);
                        break;
                    } else {
                        tmpI = tmpI + wordLength;
                        if (tmpI <= s.length() - wordLength) {
                            String next = s.substring(tmpI, tmpI + wordLength);
                            Integer nextCount = tmp.get(next);
                            if (nextCount != null && nextCount != 0) {
                                tmp.put(next, --nextCount);
                                tmpCount--;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } while (true);
            }
        }
        return ans;
    }


    @Test
    public void test2(){
        String[] words = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        LinkedList<String> full = new LinkedList<>();
        fullPermutation(full, "", words, 0);
        System.out.println(full);
    }

    /**
     * it takes so many time
     *
     * @param ans
     * @param str
     * @param candidates
     */
    private void fullPermutation(List<String> ans, String str, String[] candidates, int cs) {
        if (cs == candidates.length - 1) {
            ans.add(str + candidates[cs]);
        } else {
            for (int i = cs; i < candidates.length; i++) {
                String candidate = candidates[i];
                if (i != cs) {
                    swap(candidates, cs, i);
                    fullPermutation(ans, str + candidate, candidates, cs + 1);
                    swap(candidates, cs, i);
                } else {
                    fullPermutation(ans, str + candidate, candidates, i + 1);
                }
            }
        }
    }

    private void swap(String[] s, int a, int b) {
        String tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        if (words.length == 0) {
            return indexes;
        }
        int wordLength = words[0].length();
        int patternLength = wordLength * words.length;
        if (patternLength > s.length()) {
            return indexes;
        }

        Map<String, Integer> strings = new HashMap<>(words.length);
        for (int i = 0; i < words.length; ++i) {
            strings.put(words[i], strings.getOrDefault(words[i], 0) + 1);
        }

        Map<String, Integer> temp = new HashMap<>();
        for (int k = 0; k < wordLength; ++k) {
            for (int i = k; i <= s.length() - patternLength; i += wordLength) {
                int j = i + patternLength;
                for (; j > i; j -= wordLength) {
                    String word = s.substring(j - wordLength, j);
                    if (temp.getOrDefault(word, 0) + 1
                            > strings.getOrDefault(word, 0)) {
                        i = j - wordLength;
                        break;
                    }
                    temp.put(word, temp.getOrDefault(word, 0) + 1);
                }
                if (j == i) {
                    indexes.add(i);
                }
                temp.clear();
            }
        }
        return indexes;
    }

    @Test
    public void test5(){
        String[] words = {"foo", "bar", "zaa"};
        System.out.println(findSubstring2("asdeeqwfoozaabarwekwiip", words));
    }
}
