package datasrtuct.set;

public class UnionFindSetSimple {

    private int[] father;
    private int[] rank;

    public UnionFindSetSimple(int N) {
        father = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
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