package leetcode.hard;

import org.junit.Test;

import leetcode.element.TreeNode;

public class MaxPathSum {

    int ans = Integer.MIN_VALUE;
    int[] c = new int[7];
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return ans;
        if (root.left == null && root.right == null) return root.val;
        depth(root);
        return ans;
    }

    public Integer depth(TreeNode root) {
        if (root == null) return null;
        Integer left  = depth(root.left);
        Integer right = depth(root.right);
        int mid = root.val;
        c[0] = ans;
        c[1] = left  == null ? Integer.MIN_VALUE : left;
        c[2] = right == null ? Integer.MIN_VALUE : right;
        c[3] = mid;
        c[4] = mid + (left  == null ? 0 : left);
        c[5] = mid + (right == null ? 0 : right);
        c[6] = mid + (left  == null ? 0 : left) + (right == null ? 0 : right);
        for (int tmp : c) {
            ans = Math.max(ans, tmp);
        }
        return Math.max(c[3], Math.max(c[4], c[5]));
    }


    @Test
    public void t1() {
        TreeNode t = new TreeNode(10);
        t.right = new TreeNode(-10);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(20);
        t.right.right.left = new TreeNode(15);
        t.right.right.right = new TreeNode(-5);

        System.out.println(maxPathSum(t));
    }

    @Test
    public void t2() {
        TreeNode t = new TreeNode(2);
        t.right = new TreeNode(-1);

        System.out.println(maxPathSum(t));
    }

    @Test
    public void t3() {
        TreeNode t = new TreeNode(9);
        t.left = new TreeNode(6);
        t.right = new TreeNode(-3);
        t.right.left = new TreeNode(-6);
        t.right.right = new TreeNode(2);
        t.right.right.left = new TreeNode(2);
        t.right.right.left.left = new TreeNode(-6);
        t.right.right.left.left.left = new TreeNode(-6);
        t.right.right.left.right = new TreeNode(-6);

        System.out.println(maxPathSum(t));
    }

    @Test
    public void t4() {
        TreeNode t = new TreeNode(-3);
        t.left = new TreeNode(-1);

        System.out.println(maxPathSum(t));
    }
}