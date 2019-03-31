package leetcode.medium;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * @author youyinnn
 * Date 3/31/2019
 */
public class PermutationSequence {

    public String getPermutation(int n, int k) {
        LinkedList<String> candidate = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            candidate.add(String.valueOf(i));
        }
        int bit = n;
        while (candidate.size() > 0) {
            factorial = factorial / bit;
            bit--;
            int pick = 0;
            while (k > pick * factorial) {
                pick++;
            }
            sb.append(candidate.remove(pick - 1));
            k -= ((pick - 1) * factorial);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        assertEquals("2314", getPermutation(4, 9));
        assertEquals("1234", getPermutation(4, 1));
        assertEquals("4321", getPermutation(4, 24));
        assertEquals("213", getPermutation(3, 3));
    }

    @Test
    public void test2(){
        System.out.println(9 / 6);
        System.out.println(3 / 2);
    }

}
