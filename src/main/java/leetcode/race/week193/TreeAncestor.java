package leetcode.race.week193;

public class TreeAncestor {

    private int[] parent;

    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
    }
    
    public int getKthAncestor(int node, int k) {
        int ancestor = -1;
        int cur = node;
        while (cur > -1 && k-- > 0) {
            ancestor = parent[cur];
            cur = ancestor;
        }
        return ancestor;
    }

    public static void main(String[] args) {
        int[] a = {-1,0,0,0,3};
        TreeAncestor t = new TreeAncestor(5, a);

        System.out.println(t.getKthAncestor(1, 5));
        System.out.println(t.getKthAncestor(3, 2));
        System.out.println(t.getKthAncestor(0, 1));
        System.out.println(t.getKthAncestor(3, 1));
        System.out.println(t.getKthAncestor(3, 5));
        System.out.println(t.getKthAncestor(4, 1));
        System.out.println(t.getKthAncestor(4, 2));
    }
}