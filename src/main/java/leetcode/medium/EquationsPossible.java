package leetcode.medium;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {
        UFS ufs = new UFS(26);
        LinkedList<String> eq = new LinkedList<>();
        LinkedList<String> ineq = new LinkedList<>();
        for (int i = 0; i < equations.length; i++) {
            boolean equal = equations[i].charAt(1) == '=';
            if (equal) {
                eq.add(equations[i]);
            } else {
                ineq.add(equations[i]);
            }
        }
        Iterator<String> eqi = eq.iterator();
        while (eqi.hasNext()) {
            String next = eqi.next();
            char x = next.charAt(0);
            char y = next.charAt(3);
            ufs.merge(x - 'a', y - 'a');
        }
        Iterator<String> ineqi = ineq.iterator();
        while (ineqi.hasNext()) {
            String next = ineqi.next();
            char x = next.charAt(0);
            char y = next.charAt(3);
            if (ufs.isRelated(x - 'a', y - 'a')) {
                return false;
            }
        }
        return true;
    }

    class UFS {
        private int[] father;
        private int[] rank;
        public UFS(int N) {
            father = new int[N];
            rank = new int[N];
            for(int i = 0; i < N; i++) {
                father[i] = i;
            }
        }
        public void merge(int x, int y) {
            int xFather = findFather(x);
            int yFather = findFather(y);
            if (rank[x] <= rank[y]) {
                father[xFather] = yFather;
                if (rank[x] == rank[y] && x != y) {
                    rank[y]++;
                }
            } else {
                father[yFather] = xFather;
            }
        }
        public int findFather(int x) {
            return father[x] == x ? x : (father[x] = findFather(father[x]));
        }
        public boolean isRelated(int x, int y) {
            return findFather(x) == findFather(y);
        }
    }
    
    @Test
    public void test() {
        String[] s = {"a==b", "b!=a"};
        assertEquals(false, equationsPossible(s));
        
        String[] ss = {"b==a","a==b"};
        assertEquals(true, equationsPossible(ss));

        String[] sss = {"a==b","b==c","a==c"};
        assertEquals(true, equationsPossible(sss));
        
        String[] ssss = {"a==b","b!=c","c==a"};
        assertEquals(false, equationsPossible(ssss));
    }

    @Test
    public void test2() {
        String[] s = {"c==c","f!=a","f==b","b==c"};
        assertEquals(true, equationsPossible(s));

        String[] ss = {"a!=a"};
        assertEquals(false, equationsPossible(ss));
    }
}