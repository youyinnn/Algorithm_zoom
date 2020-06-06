package datasrtuct.set;

import static org.junit.Assert.assertEquals;

public class UnionFindSet {

    private int[] father;    
    private int[] rank;
    private boolean zipPath;
    private boolean mergeWithRank;

    public UnionFindSet(int N) {
        this(N, false, false);
    }
    
    public UnionFindSet(int N, boolean zipPath, boolean mergeWithRank) {
        if (N == Integer.MAX_VALUE) {
            N--;
        }
        this.father = new int[N + 1];
        this.rank = new int[N + 1];
        this.zipPath = zipPath;
        this.mergeWithRank = mergeWithRank;
        for (int i = 1; i <= N; i++) {
            this.father[i] = i;
            this.rank[i] = 1;
        } 
    }

    public void merge(int x, int y) {
        int xFather = findFather(x);
        int yFather = findFather(y);
        if (this.mergeWithRank) {
            // if y's flock is bigger than or equivalent to x's flock
            if (rank[x] <= rank[y]) {
                // merge x's flock to y's flock
                this.father[xFather] = yFather;
                if (rank[x] == rank[y] && x != y) {
                    rank[y]++;
                }
            } else {
                // merge y's flock to x's flock
                this.father[yFather] = xFather;
            }
        } else {
            // merge x's flock to y's flock
            // x' father is y's father
            this.father[xFather] = yFather;
        }
    }
    
    public int findFather(int x) {
        if (this.zipPath) {
            return this.father[x] == x ? x : (this.father[x] = findFather(father[x]));
        } else {
            return this.father[x] == x ? x : findFather(this.father[x]);
        }
    }

    public boolean isRelated(int x, int y) {
        return findFather(x)== findFather(y);
    }

    public static void main(String[] args) {
        UnionFindSet set = new UnionFindSet(20, true, true);
        set.merge(1, 2);
        set.merge(1, 3);
        set.merge(2, 4);
        set.merge(2, 9);
        set.merge(5, 7);
        set.merge(5, 6);
        set.merge(5, 8);
        set.merge(9, 10);
        set.merge(10, 11);
        set.merge(11, 12);
        set.merge(8, 11);
        set.merge(13, 14);

        assertEquals(true, set.isRelated(1, 2));
        assertEquals(true, set.isRelated(1, 12));
        assertEquals(true, set.isRelated(1, 8));
        assertEquals(true, set.isRelated(1, 5));
        assertEquals(false, set.isRelated(1, 13));
        assertEquals(false, set.isRelated(13, 1));
    }

}