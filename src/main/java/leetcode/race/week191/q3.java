package leetcode.race.week191;

import java.util.HashMap;

import org.junit.Test;

public class q3 {
    public int minReorder(int n, int[][] connections) {
        HashMap<Integer, Integer> go = new HashMap<>(n);
        HashMap<Integer, Integer> back = new HashMap<>(n);
        for(int[] way: connections) {
            go.put(way[0], way[1]);
            back.put(way[1], way[0]);
        }
        int count = 0;
        for (int i = n; i > 0; i--) {
            Integer ifGo = go.get(i);
            while (ifGo == null || ifGo != 0) {
                if (ifGo == null) {
                    ifGo = back.get(i);
                    back.remove(i);
                    go.put(i, ifGo);
                } else {
                    int tmp = ifGo;
                    ifGo = back.get(tmp);
                    back.remove(tmp);
                    go.put(tmp, ifGo);
                }
                count++;
            }
        }
        return count;
    }

    @Test
    public void t1() {
        int[][] a = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };
        System.out.println(minReorder(6, a));
    }
}