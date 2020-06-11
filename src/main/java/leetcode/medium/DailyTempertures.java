package leetcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class DailyTempertures {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        int[] table = new int[71];
        int lastMaxT = T[T.length - 1];
        table[lastMaxT - 30] = T.length - 1;
        for (int i = T.length - 2; i >= 0; i--) {
            int curT = T[i];
            int count = 0;
            if (curT < lastMaxT) {
                count++;
                for (int j = i + 1; j <= table[lastMaxT - 30] && T[j] <= curT; j++) {
                    count++;
                }
            }
            if (lastMaxT < curT) {
                lastMaxT = curT;
            }
            ans[i] = count;
            table[curT - 30] = i;
        }
        return ans;
    }

    @Test
    public void t1() {
        int[] t = {73,74,75,71,69,72,76,73};
        assertEquals("[1, 1, 4, 2, 1, 1, 0, 0]", Arrays.toString(dailyTemperatures(t)));

        int[] t2 = {73,75,74,72,76,79,77,77,72,74};
        assertEquals("[1, 3, 2, 1, 1, 0, 0, 0, 1, 0]", Arrays.toString(dailyTemperatures(t2)));

        int[] t3 = {30};
        assertEquals("[0]", Arrays.toString(dailyTemperatures(t3)));
    }    
    
    @Test
    public void t2() {
        int[] t = {89,62,70,58,47,47,46,76,100,70};
        assertEquals("[8, 1, 5, 4, 3, 2, 1, 1, 0, 0]", Arrays.toString(dailyTemperatures(t)));

        int[] t2 = {73,75,74,72,76,79,77,77,72,74};
        assertEquals("[1, 3, 2, 1, 1, 0, 0, 0, 1, 0]", Arrays.toString(dailyTemperatures(t2)));

        int[] t3 = {30};
        assertEquals("[0]", Arrays.toString(dailyTemperatures(t3)));
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            while (!stack.isEmpty() && temp > T[stack.peek()]) {
                int topIndex = stack.pop();
                ans[topIndex] = i - topIndex; 
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void t3() {
        int[] t = {73,74,75,71,69,72,76,73};
        assertEquals("[1, 1, 4, 2, 1, 1, 0, 0]", Arrays.toString(dailyTemperatures2(t)));

        int[] t2 = {73,75,74,72,76,79,77,77,72,74};
        assertEquals("[1, 3, 2, 1, 1, 0, 0, 0, 1, 0]", Arrays.toString(dailyTemperatures2(t2)));

        int[] t3 = {30};
        assertEquals("[0]", Arrays.toString(dailyTemperatures2(t3)));
    }    
    
    @Test
    public void t4() {
        int[] t = {89,62,70,58,47,47,46,76,100,70};
        assertEquals("[8, 1, 5, 4, 3, 2, 1, 1, 0, 0]", Arrays.toString(dailyTemperatures2(t)));

        int[] t2 = {73,75,74,72,76,79,77,77,72,74};
        assertEquals("[1, 3, 2, 1, 1, 0, 0, 0, 1, 0]", Arrays.toString(dailyTemperatures2(t2)));

        int[] t3 = {30};
        assertEquals("[0]", Arrays.toString(dailyTemperatures2(t3)));
    }
}